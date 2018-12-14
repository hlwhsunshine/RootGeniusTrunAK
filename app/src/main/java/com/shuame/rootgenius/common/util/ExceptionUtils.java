package com.shuame.rootgenius.common.util;

public final class ExceptionUtils {

    public static class FlashLogicExeption extends Exception {
        private static final long serialVersionUID = 1;
        private int _display_error_str_id;

        public FlashLogicExeption(int i, String str) {
            super(str + ":" + i);
            this._display_error_str_id = i;
        }

        public int getDisplayErrorStrId() {
            return this._display_error_str_id;
        }
    }
}
