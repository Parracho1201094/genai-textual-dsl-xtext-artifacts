package main.java.org.enorm;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
	
    private static final String LOG_FILE = "src-gen/main/java/org/enorm/files/output/logs.txt";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final boolean logs = true;

    public enum LogLevel {
        ERROR, WARNING, INFO
    }

    public static synchronized void log(LogLevel level, String message) {
        if (logs) {
            try (
                    FileWriter fw = new FileWriter(LOG_FILE, true);
                    PrintWriter pw = new PrintWriter(fw)
            ) {
                String timestamp = LocalDateTime.now().format(DATE_TIME_FORMATTER);
                pw.printf("%s [%s] - %s%n", timestamp, level, message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
