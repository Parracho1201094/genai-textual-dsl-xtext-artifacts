package org.example.lts.runtime;

@FunctionalInterface
public interface Expr {
    Object eval(EvalContext context);
}
