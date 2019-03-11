package com.gupaoedu.vip.singleton.register;



import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册式单例
 */
public class ContainerSingleton {
    private ContainerSingleton() {
    }

    private static Map<String,ContainerSingleton> map = new ConcurrentHashMap<>();

    public static Object getInstance(String className) {
        synchronized (map) {
            if (!map.containsKey(className)) {
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                return obj;
            } else {
                return map.get(className);
            }
        }
    }
}
