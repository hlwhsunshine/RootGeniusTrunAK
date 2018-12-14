package net.tsz.afinal.exception;

public class AfinalException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public AfinalException(String str) {
        super(str);
    }

    public AfinalException(String str, Throwable th) {
        super(str, th);
    }

    public AfinalException(Throwable th) {
        super(th);
    }
}
