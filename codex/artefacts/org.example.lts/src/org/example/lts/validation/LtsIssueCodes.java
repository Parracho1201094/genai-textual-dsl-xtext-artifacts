package org.example.lts.validation;

public final class LtsIssueCodes {
    public static final String PREFIX = "org.example.lts.";

    public static final String DUPLICATE_NAME = PREFIX + "duplicateName";
    public static final String DUPLICATE_COLUMN = PREFIX + "duplicateColumn";
    public static final String COLUMN_ALREADY_DECLARED = PREFIX + "columnAlreadyDeclared";
    public static final String UNKNOWN_COLUMN = PREFIX + "unknownColumn";
    public static final String UNKNOWN_FUNCTION = PREFIX + "unknownFunction";
    public static final String WRONG_ARGUMENT_COUNT = PREFIX + "wrongArgumentCount";
    public static final String INCOMPATIBLE_TYPES = PREFIX + "incompatibleTypes";
    public static final String BOOLEAN_EXPECTED = PREFIX + "booleanExpected";
    public static final String NUMERIC_EXPECTED = PREFIX + "numericExpected";
    public static final String TABLE_NOT_READY = PREFIX + "tableNotReady";
    public static final String WRONG_OUTPUT_TABLE = PREFIX + "wrongOutputTable";
    public static final String INVALID_SEPARATOR = PREFIX + "invalidSeparator";
    public static final String INVALID_IMPLEMENTATION = PREFIX + "invalidImplementation";
    public static final String AGGREGATE_CONTEXT = PREFIX + "aggregateContext";
    public static final String MISSING_LOG_LEVEL = PREFIX + "missingLogLevel";

    private LtsIssueCodes() {
    }
}
