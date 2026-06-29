package org.enorm.lts.runtime;

public final class CsvOptions {
    private final boolean header;
    private final String delimiter;

    private CsvOptions(boolean header, String delimiter) {
        this.header = header;
        this.delimiter = delimiter;
    }

    public static CsvOptions header(boolean header) {
        return new CsvOptions(header, ",");
    }

    public CsvOptions delimiter(String delimiter) {
        return new CsvOptions(header, delimiter);
    }

    public boolean hasHeader() {
        return header;
    }

    public String delimiter() {
        return delimiter;
    }
}
