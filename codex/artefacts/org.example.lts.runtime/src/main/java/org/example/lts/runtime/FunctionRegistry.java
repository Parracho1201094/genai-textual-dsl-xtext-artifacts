package org.example.lts.runtime;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

public final class FunctionRegistry {
    private final Map<String, Method> methods = new LinkedHashMap<>();

    public void register(String dslName, String implementation) {
        try {
            int separator = implementation.lastIndexOf('#');
            String className = implementation.substring(0, separator);
            String methodName = implementation.substring(separator + 1);
            Method candidate = null;
            for (Method method : Class.forName(className).getMethods()) {
                if (method.getName().equals(methodName)
                        && Modifier.isStatic(method.getModifiers())) {
                    if (candidate != null) {
                        throw new IllegalArgumentException(
                                "Overloaded extension methods are not supported: " + implementation);
                    }
                    candidate = method;
                }
            }
            if (candidate == null) {
                throw new IllegalArgumentException("No public static method: " + implementation);
            }
            methods.put(dslName, candidate);
        } catch (ReflectiveOperationException | IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException(
                    "Cannot register LTS function " + dslName + " -> " + implementation, ex);
        }
    }

    public Object invoke(String name, Object[] arguments) {
        Method method = methods.get(name);
        if (method == null) {
            throw new IllegalArgumentException("Unknown external function: " + name);
        }
        try {
            return method.invoke(null, arguments);
        } catch (ReflectiveOperationException ex) {
            throw new IllegalStateException("External function failed: " + name, ex);
        }
    }

    public boolean contains(String name) {
        return methods.containsKey(name);
    }
}
