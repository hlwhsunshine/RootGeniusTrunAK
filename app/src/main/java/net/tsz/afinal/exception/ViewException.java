package net.tsz.afinal.exception;

public class ViewException extends AfinalException {
    private static final long serialVersionUID = 1;
    private String strMsg = null;

    public ViewException(String str) {
        this.strMsg = str;
    }

    public void printStackTrace() {
        if (this.strMsg != null) {
            System.err.println(this.strMsg);
        }
        super.printStackTrace();
    }
}
