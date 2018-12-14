package android.support.p015v4.speech.tts;

import android.content.Context;
import android.os.Build.VERSION;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

/* renamed from: android.support.v4.speech.tts.TextToSpeechICS */
class TextToSpeechICS {
    private static final String TAG = "android.support.v4.speech.tts";

    TextToSpeechICS() {
    }

    static TextToSpeech construct(Context context, OnInitListener onInitListener, String str) {
        return VERSION.SDK_INT < 14 ? str == null ? new TextToSpeech(context, onInitListener) : new TextToSpeech(context, onInitListener) : new TextToSpeech(context, onInitListener, str);
    }
}
