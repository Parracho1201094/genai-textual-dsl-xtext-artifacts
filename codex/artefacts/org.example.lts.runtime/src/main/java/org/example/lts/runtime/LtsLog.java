package org.example.lts.runtime;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public final class LtsLog {
    private final List<String> entries = new ArrayList<>();

    public void warning(String message) {
        entries.add(Instant.now() + " WARNING " + message);
    }

    public void error(String message) {
        entries.add(Instant.now() + " ERROR " + message);
    }

    public void save(Path path) throws IOException {
        Path parent = path.toAbsolutePath().getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
        Files.write(path, entries, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}
