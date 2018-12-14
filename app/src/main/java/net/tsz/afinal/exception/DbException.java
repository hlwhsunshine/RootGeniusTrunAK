package net.tsz.afinal.exception;

public class DbException extends AfinalException {
    private static final long serialVersionUID = 1;

    public DbException(String str) {
        super(str);
    }

    public DbException(String str, Throwable th) {
        super(str, th);
    }

    public DbException(Throwable th) {
        super(th);
    }
}
