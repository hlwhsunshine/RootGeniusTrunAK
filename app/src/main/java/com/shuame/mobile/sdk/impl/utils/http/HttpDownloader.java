package com.shuame.mobile.sdk.impl.utils.http;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpDownloader {
    /* renamed from: a */
    private static final String f3243a = HttpDownloader.class.getSimpleName();
    /* renamed from: b */
    private static HttpDownloader f3244b;
    /* renamed from: c */
    private ExecutorService f3245c = Executors.newCachedThreadPool();
    /* renamed from: d */
    private Map<String, C1232a> f3246d = new ConcurrentHashMap();
    /* renamed from: e */
    private Map<Integer, TaskInfo> f3247e = new ConcurrentHashMap();

    private HttpDownloader() {
    }

    /* renamed from: a */
    private int m3462a(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            i2 += str.charAt(i);
            i2 += i2 << 10;
            i2 ^= i2 >> 6;
            i++;
        }
        i = (i2 << 3) + i2;
        i ^= i >> 11;
        i += i << 15;
        return i < 0 ? -i : i;
    }

    /* renamed from: a */
    private void m3463a() {
        if (this.f3245c != null) {
            this.f3245c.shutdown();
        }
        if (this.f3246d != null) {
            this.f3246d.clear();
        }
        if (this.f3247e != null) {
            this.f3247e.clear();
        }
    }

    public static void destroy() {
        if (f3244b != null) {
            synchronized (HttpDownloader.class) {
                if (f3244b != null) {
                    f3244b.m3463a();
                    f3244b = null;
                }
            }
        }
    }

    public static HttpDownloader getInstance() {
        if (f3244b == null) {
            synchronized (HttpDownloader.class) {
                if (f3244b == null) {
                    f3244b = new HttpDownloader();
                }
            }
        }
        return f3244b;
    }

    public void cancel(int i) {
        if (this.f3247e.containsKey(Integer.valueOf(i))) {
            TaskInfo taskInfo = (TaskInfo) this.f3247e.get(Integer.valueOf(i));
            if (taskInfo != null) {
                cancel(taskInfo.url);
            }
            this.f3247e.remove(Integer.valueOf(i));
        }
    }

    public void cancel(String str) {
        if (this.f3246d.containsKey(str)) {
            C1232a c1232a = (C1232a) this.f3246d.get(str);
            if (c1232a != null) {
                c1232a.mo6854a();
            }
            this.f3246d.remove(str);
        }
    }

    public void cancelAll() {
        for (C1232a c1232a : this.f3246d.values()) {
            if (c1232a != null) {
                c1232a.mo6854a();
            }
        }
        this.f3246d.clear();
        this.f3247e.clear();
    }

    public int download(TaskInfo taskInfo, OnDownloadListener onDownloadListener) {
        taskInfo.taskId = m3462a(taskInfo.url);
        Runnable c1232a = new C1232a(taskInfo, onDownloadListener);
        this.f3246d.put(taskInfo.url, c1232a);
        this.f3247e.put(Integer.valueOf(taskInfo.taskId), taskInfo);
        this.f3245c.submit(c1232a);
        return taskInfo.taskId;
    }
}
