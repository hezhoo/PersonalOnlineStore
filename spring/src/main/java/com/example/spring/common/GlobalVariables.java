package com.example.spring.common;

/**
 * @author 25622
 */
public class GlobalVariables {
    static GlobalVariables instance;
    static String globalPhone;
    static int globalId;

    private GlobalVariables() {
        // 私有构造函数，防止外部实例化
    }

    public static synchronized GlobalVariables getInstance() {
        if (instance == null) {
            instance = new GlobalVariables();
        }
        return instance;
    }

    public int getGlobalId() {
        return globalId;
    }

    public static void setGlobalId(int value) {
        globalId = value;
    }

    public String getGlobalPhone() {
        return globalPhone;
    }

    public static void setGlobalPhone(String value) {
        globalPhone = value;
    }
}

