package org.keplerproject.luajava;

public class LuaException extends Exception {
    private static final long serialVersionUID = 1;

    public LuaException(Exception exception) {
        Throwable exception2;
        if (exception2.getCause() != null) {
            exception2 = exception2.getCause();
        }
        super(exception2);
    }

    public LuaException(String str) {
        super(str);
    }
}
