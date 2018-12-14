package com.tencent.stat;

public class StatGameUser implements Cloneable {
    /* renamed from: a */
    private String f4854a = "";
    /* renamed from: b */
    private String f4855b = "";
    /* renamed from: c */
    private String f4856c = "";

    public StatGameUser(String str, String str2, String str3) {
        this.f4855b = str;
        this.f4854a = str2;
        this.f4856c = str3;
    }

    public StatGameUser clone() {
        try {
            return (StatGameUser) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public String getAccount() {
        return this.f4855b;
    }

    public String getLevel() {
        return this.f4856c;
    }

    public String getWorldName() {
        return this.f4854a;
    }

    public void setAccount(String str) {
        this.f4855b = str;
    }

    public void setLevel(String str) {
        this.f4856c = str;
    }

    public void setWorldName(String str) {
        this.f4854a = str;
    }

    public String toString() {
        return "StatGameUser [worldName=" + this.f4854a + ", account=" + this.f4855b + ", level=" + this.f4856c + "]";
    }
}
