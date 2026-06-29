package org.enorm.lts.runtime;

import java.io.IOException;
import java.nio.file.*;
import java.time.Instant;
import java.util.*;

public final class ProcessLogger {
    private final List<String> entries = new ArrayList<>();

    public void info(String message) { entries.add("INFO  " + Instant.now() + " " + message); }
    public void warn(String message) { entries.add("WARN  " + Instant.now() + " " + message); }
    public void error(String message) { entries.add("ERROR " + Instant.now() + " " + message); }

    public List<String> entries() { return List.copyOf(entries); }

    public void save(Path path) throws IOException {
        if (path.getParent() != null) Files.createDirectories(path.getParent());
        Files.write(path, entries, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
