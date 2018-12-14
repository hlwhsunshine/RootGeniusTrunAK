package com.shuame.rootgenius.common.util;

public class BottleFileException extends Exception {
    private static final long serialVersionUID = 1;
    private String _error_type;

    public BottleFileException(String str, String str2) {
        super(str2);
        this._error_type = str;
    }

    public String getErrorType() {
        return this._error_type;
    }
}
