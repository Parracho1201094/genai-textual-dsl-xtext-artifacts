package org.enorm.lts.runtime;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public final class CsvSaver {
    private CsvSaver() {}

    public static void save(Table table, Path path, CsvOptions options, ProcessLogger log) throws IOException {
        if (path.getParent() != null) Files.createDirectories(path.getParent());
        List<String> lines = new ArrayList<>();
        if (options.hasHeader()) {
            lines.add(String.join(options.delimiter(), table.schema().columns().stream().map(Column::name).toList()));
        }
        for (Row row : table.rows()) {
            List<String> cells = new ArrayList<>();
            for (Column col : table.schema().columns()) {
                Object value = row.get(col.name());
                cells.add(escape(value == null ? "" : String.valueOf(value), options.delimiter()));
            }
            lines.add(String.join(options.delimiter(), cells));
        }
        Files.write(path, lines, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        log.info("Saved " + table.rows().size() + " rows to " + path + ".");
    }

    private static String escape(String value, String delimiter) {
        if (value.contains(delimiter) || value.contains("\"") || value.contains("\n")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }
}
