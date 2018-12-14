package org.keplerproject.luajava;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {
    public static void main(String[] strArr) {
        int i = 0;
        try {
            LuaState newLuaState = LuaStateFactory.newLuaState();
            newLuaState.openLibs();
            if (strArr.length > 0) {
                while (true) {
                    int i2 = i;
                    if (i2 < strArr.length) {
                        i = newLuaState.LloadFile(strArr[i2]);
                        if (i == 0) {
                            i = newLuaState.pcall(0, 0, 0);
                        }
                        if (i != 0) {
                            throw new LuaException("Error on file: " + strArr[i2] + ". " + newLuaState.toString(-1));
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
            System.out.println("API Lua Java - console mode.");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("> ");
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.equals("exit")) {
                    newLuaState.close();
                } else {
                    i = newLuaState.LloadBuffer(readLine.getBytes(), "from console");
                    if (i == 0) {
                        i = newLuaState.pcall(0, 0, 0);
                    }
                    if (i != 0) {
                        System.err.println("Error on line: " + readLine);
                        System.err.println(newLuaState.toString(-1));
                    }
                }
            }
            newLuaState.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
