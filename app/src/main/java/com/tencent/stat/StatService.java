package com.tencent.stat;

import android.app.Application;
import android.content.Context;
import java.util.Map;
import java.util.Properties;

public class StatService {
    public static void addActionListener(StatActionListener statActionListener) {
        StatServiceImpl.addActionListener(statActionListener);
    }

    public static void commitEvents(Context context, int i) {
        StatServiceImpl.commitEvents(context, i);
    }

    public static void flushDataToDB(Context context) {
        StatServiceImpl.flushDataToDB(context);
    }

    public static Properties getCommonKeyValueForKVEvent(String str) {
        return StatServiceImpl.getCommonKeyValueForKVEvent(str);
    }

    public static void getFeedBackMessage(Context context, int i, int i2, StatFBDispatchCallback statFBDispatchCallback) {
        StatServiceImpl.getFeedBackMessage(context, i, i2, statFBDispatchCallback);
    }

    public static boolean isBackground() {
        return StatServiceImpl.isBackground();
    }

    public static boolean isForeground() {
        return StatServiceImpl.isForeground();
    }

    public static void onLowMemory(Context context) {
        StatServiceImpl.onLowMemory(context);
    }

    public static void onPause(Context context) {
        StatServiceImpl.onPause(context, null);
    }

    public static void onResume(Context context) {
        StatServiceImpl.onResume(context, null);
    }

    public static void onStop(Context context) {
        StatServiceImpl.onStop(context, null);
    }

    public static void postFeedBackFiles(Context context, String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        StatServiceImpl.postFeedBackFiles(context, str, str2, statFBDispatchCallback);
    }

    public static void registerActivityLifecycleCallbacks(Application application) {
        StatServiceImpl.registerActivityLifecycleCallbacks(application, null);
    }

    public static void removeActionListener(StatActionListener statActionListener) {
        StatServiceImpl.removeActionListener(statActionListener);
    }

    public static void replyFeedBackMessage(Context context, String str, String str2, StatFBDispatchCallback statFBDispatchCallback) {
        StatServiceImpl.replyFeedBackMessage(context, str, str2, statFBDispatchCallback);
    }

    public static void reportAccount(Context context, StatAccount statAccount) {
        StatServiceImpl.reportAccount(context, statAccount, null);
    }

    public static void reportAppMonitorStat(Context context, StatAppMonitor statAppMonitor) {
        StatServiceImpl.reportAppMonitorStat(context, statAppMonitor, null);
    }

    public static void reportError(Context context, String str) {
        StatServiceImpl.reportError(context, str, null);
    }

    public static void reportException(Context context, Throwable th) {
        StatServiceImpl.reportException(context, th, null);
    }

    public static void reportGameUser(Context context, StatGameUser statGameUser) {
        StatServiceImpl.reportGameUser(context, statGameUser, null);
    }

    public static void reportQQ(Context context, String str) {
        StatServiceImpl.reportQQ(context, str, null);
    }

    public static void setCommonKeyValueForKVEvent(String str, Properties properties) {
        StatServiceImpl.setCommonKeyValueForKVEvent(str, properties);
    }

    public static void setContext(Context context) {
        StatServiceImpl.setContext(context);
    }

    public static void setEnvAttributes(Context context, Map<String, String> map) {
        StatServiceImpl.setEnvAttributes(context, map);
    }

    public static void startNewSession(Context context) {
        StatServiceImpl.startNewSession(context, null);
    }

    public static boolean startStatService(Context context, String str, String str2) {
        return StatServiceImpl.startStatService(context, str, str2, null);
    }

    public static void stopSession() {
        StatServiceImpl.stopSession();
    }

    public static void testSpeed(Context context) {
        StatServiceImpl.testSpeed(context);
    }

    public static void testSpeed(Context context, Map<String, Integer> map) {
        StatServiceImpl.testSpeed(context, map, null);
    }

    public static void trackBeginPage(Context context, String str) {
        StatServiceImpl.trackBeginPage(context, str, null);
    }

    public static void trackCustomBeginEvent(Context context, String str, String... strArr) {
        StatServiceImpl.trackCustomBeginEvent(context, str, null, strArr);
    }

    public static void trackCustomBeginKVEvent(Context context, String str, Properties properties) {
        StatServiceImpl.trackCustomBeginKVEvent(context, str, properties, null);
    }

    public static void trackCustomEndEvent(Context context, String str, String... strArr) {
        StatServiceImpl.trackCustomEndEvent(context, str, null, strArr);
    }

    public static void trackCustomEndKVEvent(Context context, String str, Properties properties) {
        StatServiceImpl.trackCustomEndKVEvent(context, str, properties, null);
    }

    public static void trackCustomEvent(Context context, String str, String... strArr) {
        StatServiceImpl.trackCustomEvent(context, str, null, strArr);
    }

    public static void trackCustomKVEvent(Context context, String str, Properties properties) {
        StatServiceImpl.trackCustomKVEvent(context, str, properties, null);
    }

    public static void trackCustomKVTimeIntervalEvent(Context context, int i, String str, Properties properties) {
        StatServiceImpl.trackCustomKVTimeIntervalEvent(context, str, properties, i, null);
    }

    public static void trackEndPage(Context context, String str) {
        StatServiceImpl.trackEndPage(context, str, null);
    }
}
