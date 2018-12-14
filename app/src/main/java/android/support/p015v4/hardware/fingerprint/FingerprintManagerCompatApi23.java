package android.support.p015v4.hardware.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23 */
public final class FingerprintManagerCompatApi23 {

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationCallback */
    public static abstract class AuthenticationCallback {
        public void onAuthenticationError(int i, CharSequence charSequence) {
        }

        public void onAuthenticationFailed() {
        }

        public void onAuthenticationHelp(int i, CharSequence charSequence) {
        }

        public void onAuthenticationSucceeded(AuthenticationResultInternal authenticationResultInternal) {
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$AuthenticationResultInternal */
    public static final class AuthenticationResultInternal {
        private CryptoObject mCryptoObject;

        public AuthenticationResultInternal(CryptoObject cryptoObject) {
            this.mCryptoObject = cryptoObject;
        }

        public final CryptoObject getCryptoObject() {
            return this.mCryptoObject;
        }
    }

    /* renamed from: android.support.v4.hardware.fingerprint.FingerprintManagerCompatApi23$CryptoObject */
    public static class CryptoObject {
        private final Cipher mCipher;
        private final Mac mMac;
        private final Signature mSignature;

        public CryptoObject(Signature signature) {
            this.mSignature = signature;
            this.mCipher = null;
            this.mMac = null;
        }

        public CryptoObject(Cipher cipher) {
            this.mCipher = cipher;
            this.mSignature = null;
            this.mMac = null;
        }

        public CryptoObject(Mac mac) {
            this.mMac = mac;
            this.mCipher = null;
            this.mSignature = null;
        }

        public Cipher getCipher() {
            return this.mCipher;
        }

        public Mac getMac() {
            return this.mMac;
        }

        public Signature getSignature() {
            return this.mSignature;
        }
    }

    public static void authenticate(Context context, CryptoObject cryptoObject, int i, Object obj, AuthenticationCallback authenticationCallback, Handler handler) {
        FingerprintManagerCompatApi23.getFingerprintManager(context).authenticate(FingerprintManagerCompatApi23.wrapCryptoObject(cryptoObject), (CancellationSignal) obj, i, FingerprintManagerCompatApi23.wrapCallback(authenticationCallback), handler);
    }

    private static FingerprintManager getFingerprintManager(Context context) {
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    public static boolean hasEnrolledFingerprints(Context context) {
        return FingerprintManagerCompatApi23.getFingerprintManager(context).hasEnrolledFingerprints();
    }

    public static boolean isHardwareDetected(Context context) {
        return FingerprintManagerCompatApi23.getFingerprintManager(context).isHardwareDetected();
    }

    private static CryptoObject unwrapCryptoObject(CryptoObject cryptoObject) {
        return cryptoObject == null ? null : cryptoObject.getCipher() != null ? new CryptoObject(cryptoObject.getCipher()) : cryptoObject.getSignature() != null ? new CryptoObject(cryptoObject.getSignature()) : cryptoObject.getMac() != null ? new CryptoObject(cryptoObject.getMac()) : null;
    }

    private static AuthenticationCallback wrapCallback(final AuthenticationCallback authenticationCallback) {
        return new AuthenticationCallback() {
            public final void onAuthenticationError(int i, CharSequence charSequence) {
                authenticationCallback.onAuthenticationError(i, charSequence);
            }

            public final void onAuthenticationFailed() {
                authenticationCallback.onAuthenticationFailed();
            }

            public final void onAuthenticationHelp(int i, CharSequence charSequence) {
                authenticationCallback.onAuthenticationHelp(i, charSequence);
            }

            public final void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
                authenticationCallback.onAuthenticationSucceeded(new AuthenticationResultInternal(FingerprintManagerCompatApi23.unwrapCryptoObject(authenticationResult.getCryptoObject())));
            }
        };
    }

    private static CryptoObject wrapCryptoObject(CryptoObject cryptoObject) {
        return cryptoObject == null ? null : cryptoObject.getCipher() != null ? new CryptoObject(cryptoObject.getCipher()) : cryptoObject.getSignature() != null ? new CryptoObject(cryptoObject.getSignature()) : cryptoObject.getMac() != null ? new CryptoObject(cryptoObject.getMac()) : null;
    }
}
