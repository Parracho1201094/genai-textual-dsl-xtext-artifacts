package org.enorm.lts.runtime;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public final class CsvLoader {
    private CsvLoader() {}

    public static Table load(Path path, Schema schema, CsvOptions options, ProcessLogger log) throws IOException {
        List<String> lines = Files.readAllLines(path);
        List<Row> rows = new ArrayList<>();
        int start = options.hasHeader() && !lines.isEmpty() ? 1 : 0;
        if (options.hasHeader() && !lines.isEmpty()) {
            log.info("Loaded header from " + path + ": " + lines.get(0));
        }
        for (int i = start; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.isBlank()) continue;
            List<String> cells = split(line, options.delimiter().charAt(0));
            Row row = new Row();
            int c = 0;
            for (Column col : schema.columns()) {
                String raw = c < cells.size() ? cells.get(c) : "";
                try {
                    row.set(col.name(), parse(raw, col.type()));
                } catch (RuntimeException ex) {
                    log.warn("Invalid value '" + raw + "' for " + col.name() + ":" + col.type() + " at " + path + ":" + (i + 1) + ". Stored null.");
                    row.set(col.name(), null);
                }
                c++;
            }
            rows.add(row);
        }
        log.info("Loaded " + rows.size() + " rows from " + path + ".");
        return new Table(fileNameWithoutExtension(path), schema, rows);
    }

    private static Object parse(String raw, Type type) {
        String s = raw == null ? "" : raw.trim();
        if (s.isEmpty()) return null;
        return switch (type) {
            case INT -> Integer.parseInt(s);
            case DECIMAL -> new BigDecimal(s);
            case STRING -> s;
            case DATE -> LocalDate.parse(s);
            case BOOLEAN -> Boolean.parseBoolean(s);
        };
    }

    private static String fileNameWithoutExtension(Path path) {
        String name = path.getFileName().toString();
        int dot = name.lastIndexOf('.');
        return dot > 0 ? name.substring(0, dot) : name;
    }

    static List<String> split(String line, char delimiter) {
        List<String> cells = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '"') {
                if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    current.append('"');
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (ch == delimiter && !inQuotes) {
                cells.add(current.toString());
                current.setLength(0);
            } else {
                current.append(ch);
            }
        }
        cells.add(current.toString());
        return cells;
    }
}
