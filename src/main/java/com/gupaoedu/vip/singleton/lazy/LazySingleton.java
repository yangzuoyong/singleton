package com.gupaoedu.vip.singleton.lazy;

/**
 * 懒汉式单例:在外部需要使用的时候才进行实例化
 * 优点：不使用不加载
 * 缺点：自己处理线程安全问题
 */
public class LazySingleton {
    private LazySingleton(){}
    //静态块，公共内存区域
    private static LazySingleton lazy = null;
    public synchronized static LazySingleton getInstance(){
        if(lazy == null){
            lazy = new LazySingleton();
        }
        return lazy;
    }
}
