package com.gupaoedu.vip.singleton;

/**
 *  GP12713
 * 饿汉式单例:在类加载的时候就立即初始化，并且创建单例对象
 * 优点：没有加任何的锁、执行效率比较高
 * 缺点：类加载的时候就初始化，如果不用浪费内存
 * 线程安全：绝对线程安全，在线程还没出现以前就是实例化了，不可能存在访问安全问题
 */
public class HungrySingleton {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return  hungrySingleton;
    }
}
