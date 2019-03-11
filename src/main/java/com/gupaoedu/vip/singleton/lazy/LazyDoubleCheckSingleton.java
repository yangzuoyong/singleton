package com.gupaoedu.vip.singleton.lazy;

/**
 * 双重校验
 */
public class LazyDoubleCheckSingleton {
    private volatile static LazyDoubleCheckSingleton dcLazy = null;
    private LazyDoubleCheckSingleton(){}
    public static LazyDoubleCheckSingleton getInstance(){
        if(dcLazy == null){
            synchronized (LazyDoubleCheckSingleton.class){
                if(dcLazy == null){
                    dcLazy = new LazyDoubleCheckSingleton();
                    //1.分配内存给这个对象
                    //2.初始化对象
                    //3.设置lazy指向刚分配的内存地址
                    //4.初次访问对象
                }
            }
        }
        return dcLazy;
    }
}
