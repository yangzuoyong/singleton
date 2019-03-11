package com.gupaoedu.vip.singleton.register;
/**
 * 注册式，类名+枚举值被JVM保存
 * 不能用反射创建枚举
 */
public enum EnumSingleton {
    INSTANCE;
    private Object data;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
