package org.enorm.lts.custom;

import java.math.BigDecimal;

/**
 * Manual extension point. The generator should call this class for functions that are not
 * built into the DSL runtime. This file should not be overwritten after user edits.
 */
public final class CustomFunctions {
    private CustomFunctions() {}

    public static String concat(Object... parts) {
        StringBuilder sb = new StringBuilder();
        for (Object part : parts) {
            if (part != null) sb.append(part);
        }
        return sb.toString();
    }

    public static String passFail(BigDecimal grade) {
        return grade != null && grade.compareTo(BigDecimal.valueOf(9.5)) >= 0 ? "PASS" : "FAIL";
    }
}
