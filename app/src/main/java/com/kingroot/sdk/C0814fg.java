package com.kingroot.sdk;

import android.text.TextUtils;
import android.util.SparseArray;
import com.kingroot.sdk.C0845gh.C0844a;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.kingroot.sdk.fg */
public class C0814fg {
    /* renamed from: ji */
    private C0716ga f2059ji = null;

    private C0814fg() {
    }

    public C0814fg(C0716ga c0716ga) {
        this.f2059ji = c0716ga;
    }

    /* renamed from: a */
    private SparseArray<String> m2059a(List<C0844a> list, SparseArray<String> sparseArray, SparseArray<String> sparseArray2, List<String> list2, List<String> list3) {
        SparseArray<String> sparseArray3 = new SparseArray(1);
        for (C0844a c0844a : list) {
            if (c0844a.uid == 0 && m2061a(sparseArray, sparseArray2, list2, c0844a.pid)) {
                C0825fq.m2099g("KuSdkDaemonClean", "root daemon #" + c0844a.name);
                sparseArray3.put(c0844a.pid, c0844a.name);
                list3.add(c0844a.name);
            }
        }
        return sparseArray3;
    }

    /* renamed from: a */
    private boolean m2060a(SparseArray<String> sparseArray) {
        if (sparseArray == null || sparseArray.size() <= 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < sparseArray.size(); i++) {
            String num = Integer.toString(sparseArray.keyAt(i));
            if (num != null) {
                if (stringBuilder.length() != 0) {
                    stringBuilder.append(" && ");
                }
                stringBuilder.append("kill -9 ");
                stringBuilder.append(num);
            }
        }
        C0836fz ah = m2062ah(stringBuilder.toString());
        if (ah == null || (ah.success() && !ah.f2085cs.contains("Failure"))) {
            return true;
        }
        C0825fq.m2101r("KuSdkDaemonClean", "killDaemon failed! script: " + stringBuilder + "; error:" + ah.f2086ct);
        return false;
    }

    /* renamed from: a */
    private boolean m2061a(SparseArray<String> sparseArray, SparseArray<String> sparseArray2, List<String> list, int i) {
        String str = (String) sparseArray.get(i);
        String str2 = (String) sparseArray2.get(i);
        for (String str3 : list) {
            if ((str != null && str.contains(str3)) || (str2 != null && str2.contains(str3))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ah */
    private C0836fz m2062ah(String str) {
        C0825fq.m2099g("KuSdkDaemonClean", "runScript(), script:" + str);
        return this.f2059ji.mo5683K(str);
    }

    /* renamed from: b */
    private void m2063b(List<String> list, List<String> list2, List<String> list3) {
        try {
            List<C0844a> bK = m2064bK();
            SparseArray a = m2059a(bK, m2066j(bK), m2067k(bK), list2, list3);
            for (String str : list) {
                for (C0844a c0844a : bK) {
                    if (m2068p(c0844a.name, str) && a.get(c0844a.pid) == null) {
                        a.put(c0844a.pid, c0844a.name);
                        list3.add(c0844a.name);
                    }
                }
            }
            if (!m2060a(a)) {
                list3.clear();
            }
        } catch (Throwable e) {
            C0825fq.m2096a(e);
        }
    }

    /* renamed from: bK */
    private LinkedList<C0844a> m2064bK() {
        return m2065i(false);
    }

    /* renamed from: i */
    private LinkedList<C0844a> m2065i(boolean z) {
        List<C0844a> l = C0845gh.m2192l(null);
        LinkedList<C0844a> linkedList = new LinkedList();
        if (l != null) {
            for (C0844a c0844a : l) {
                C0825fq.m2099g("KuSdkDaemonClean", "readProcessList(); name:" + c0844a.name + "; uid:" + c0844a.uid + "; pid:" + c0844a.pid + "; ppid:" + c0844a.f2099jE);
                if (c0844a.f2099jE != 2 && c0844a.uid == 0) {
                    if (z || !(m2068p(c0844a.name, "ku.sud") || m2068p(c0844a.name, "daemonsu") || m2068p(c0844a.name, "kuInotify"))) {
                        linkedList.add(c0844a);
                    }
                }
            }
        }
        return linkedList;
    }

    /* renamed from: j */
    private SparseArray<String> m2066j(List<C0844a> list) {
        SparseArray<String> sparseArray = new SparseArray(1);
        for (C0844a c0844a : list) {
            if (c0844a.uid == 0) {
                C0836fz ah = m2062ah(new StringBuilder(String.valueOf(C0822fn.m2082bQ() + " ")).append("head /proc/").append(c0844a.pid).append("/maps").toString());
                String str = ah.f2085cs;
                if (ah == null || (ah.success() && !ah.f2085cs.contains("Failure"))) {
                    C0825fq.m2099g("KuSdkDaemonClean", "readMapsFirstLines(), pid:" + c0844a.pid + "; mapsLine:" + str);
                    sparseArray.put(c0844a.pid, str);
                } else {
                    C0825fq.m2102s("KuSdkDaemonClean", "maps error: " + ah.f2086ct);
                }
            }
        }
        return sparseArray;
    }

    /* renamed from: k */
    private SparseArray<String> m2067k(List<C0844a> list) {
        SparseArray<String> sparseArray = new SparseArray(1);
        for (C0844a c0844a : list) {
            if (c0844a.uid == 0) {
                C0836fz ah = m2062ah(String.format("cat %s", new Object[]{"/proc/" + c0844a.pid + "/environ"}));
                String str = ah.f2085cs;
                if (!ah.success() || str == null) {
                    C0825fq.m2102s("KuSdkDaemonClean", "cmdlines error: " + sparseArray.size());
                } else if (sparseArray.get(c0844a.pid) != null) {
                    throw new IllegalStateException();
                } else {
                    C0825fq.m2099g("KuSdkDaemonClean", "readEnvirons(), pid:" + c0844a.pid + "; env:" + str);
                    sparseArray.put(c0844a.pid, str);
                }
                if (c0844a.uid != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        return sparseArray;
    }

    /* renamed from: p */
    private boolean m2068p(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) ? false : str.equals(str2) || str.startsWith(str2) || str.endsWith(str2);
    }

    /* renamed from: a */
    public void mo5817a(List<String> list, List<String> list2, List<String> list3) {
        try {
            m2063b(list, list2, list3);
        } catch (Throwable e) {
            C0825fq.m2096a(e);
        }
    }
}
