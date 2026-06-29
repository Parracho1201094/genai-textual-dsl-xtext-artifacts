package com.acme.lts;

import java.math.BigDecimal;

public final class PayrollFunctions {
    private PayrollFunctions() {
    }

    public static BigDecimal overtime(
            BigDecimal hours, BigDecimal limit, BigDecimal rate) {
        if (hours == null || hours.compareTo(limit) <= 0) {
            return BigDecimal.ZERO;
        }
        return hours.subtract(limit).multiply(rate);
    }
}
