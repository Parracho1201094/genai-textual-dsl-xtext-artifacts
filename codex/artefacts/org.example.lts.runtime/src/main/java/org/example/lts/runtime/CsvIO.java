package org.example.lts.runtime;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public final class CsvIO {
    private CsvIO() {
    }

    public static DataTable read(String tableName, Path path, char separator,
            boolean hasHeader, Schema schema, LtsLog log) throws IOException {
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        DataTable table = new DataTable(tableName, schema);
        if (lines.isEmpty()) {
            log.warning("Input CSV is empty: " + path);
            return table;
        }

        List<String> headers = hasHeader
                ? parseLine(lines.get(0), separator)
                : schema.fields().stream().map(Schema.Field::name)
                        .collect(java.util.stream.Collectors.toList());
        int firstDataLine = hasHeader ? 1 : 0;

        for (int lineNumber = firstDataLine; lineNumber < lines.size(); lineNumber++) {
            List<String> values = parseLine(lines.get(lineNumber), separator);
            Row row = new Row();
            for (Schema.Field field : schema.fields()) {
                int index = headers.indexOf(field.name());
                String raw = index >= 0 && index < values.size() ? values.get(index) : "";
                if (raw.isEmpty() && field.required()) {
                    log.error("Missing required value " + tableName + "." + field.name()
                            + " at CSV line " + (lineNumber + 1));
                }
                try {
                    row.put(field.name(), parseValue(raw, field));
                } catch (RuntimeException ex) {
                    log.error("Invalid " + field.type() + " value '" + raw + "' for "
                            + tableName + "." + field.name() + " at CSV line "
                            + (lineNumber + 1));
                    row.put(field.name(), null);
                }
            }
            table.rows().add(row);
        }
        return table;
    }

    public static void write(DataTable table, Path path, char separator,
            boolean includeHeader) throws IOException {
        Path parent = path.toAbsolutePath().getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
        List<String> lines = new ArrayList<>();
        List<String> columns = table.schema().fields().stream().map(Schema.Field::name)
                .collect(java.util.stream.Collectors.toList());
        if (includeHeader) {
            lines.add(join(columns, separator));
        }
        for (Row row : table.rows()) {
            List<String> values = new ArrayList<>();
            for (String column : columns) {
                Object value = row.get(column);
                values.add(value == null ? "" : value.toString());
            }
            lines.add(join(values, separator));
        }
        Files.write(path, lines, StandardCharsets.UTF_8);
    }

    static List<String> parseLine(String line, char separator) {
        List<String> values = new ArrayList<>();
        StringBuilder value = new StringBuilder();
        boolean quoted = false;
        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            if (current == '"') {
                if (quoted && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    value.append('"');
                    i++;
                } else {
                    quoted = !quoted;
                }
            } else if (current == separator && !quoted) {
                values.add(value.toString());
                value.setLength(0);
            } else {
                value.append(current);
            }
        }
        values.add(value.toString());
        return values;
    }

    private static Object parseValue(String raw, Schema.Field field) {
        if (raw == null || raw.isEmpty()) {
            return null;
        }
        switch (field.type()) {
        case STRING:
            return raw;
        case INTEGER:
            return Long.valueOf(raw);
        case DECIMAL:
            return new BigDecimal(raw);
        case BOOLEAN:
            return Boolean.valueOf(raw);
        case DATE:
            return LocalDate.parse(raw, formatter(field, false));
        case DATETIME:
            return LocalDateTime.parse(raw, formatter(field, true));
        default:
            throw new IllegalStateException("Unsupported type: " + field.type());
        }
    }

    private static DateTimeFormatter formatter(Schema.Field field, boolean dateTime) {
        return field.format() == null || field.format().isEmpty()
                ? (dateTime ? DateTimeFormatter.ISO_DATE_TIME : DateTimeFormatter.ISO_DATE)
                : DateTimeFormatter.ofPattern(field.format());
    }

    private static String join(List<String> values, char separator) {
        return values.stream().map(v -> quote(v, separator))
                .collect(java.util.stream.Collectors.joining(String.valueOf(separator)));
    }

    private static String quote(String value, char separator) {
        if (value.indexOf(separator) >= 0 || value.contains("\"")
                || value.contains("\n") || value.contains("\r")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }
}
