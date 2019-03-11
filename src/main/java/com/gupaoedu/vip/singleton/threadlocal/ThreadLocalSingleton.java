package com.gupaoedu.vip.singleton.threadlocal;

/**
 * 伪线程安全
 * 统一线程内单例
 * <p>
 * 使用ThreadLocal实现多数据源动态切换
 * <p>
 * ThreadLocal#set()
 * ThreadLocalMap
 * key:线程
 * value:自己设的东西
 */
public class ThreadLocalSingleton {
    private static final ThreadLocal<ThreadLocalSingleton> threadLocalInstance =
            new ThreadLocal<ThreadLocalSingleton>() {
                @Override
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    private ThreadLocalSingleton() {
    }

    public static ThreadLocalSingleton getInstance() {
        return threadLocalInstance.get();
    }
}
