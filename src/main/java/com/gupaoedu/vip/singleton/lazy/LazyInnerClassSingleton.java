package com.gupaoedu.vip.singleton.lazy;

/**
 * 内部类单例：没用到sync关键字，性能更好
 * 反射可以破坏单例
 * 解决：构造方法做判断
 * 序列化可以破坏单例
 * 解决：  ObjectInputStream、ObjectOutputStream
 *       需要重构readReslove方法，只不过是覆盖了反序列化出来的对象
 *        还是创建了两次，发生在JVM层面，相对来说比较安全
 *       之前反序列化的对象被GC
 */
public class LazyInnerClassSingleton {
    //默认使用LazyInnerClassGeneral的时候，会先初始化内部类
    //如果没使用的话，内部类是不加载的
    private LazyInnerClassSingleton(){
        if(LazyHolder.LAZY != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    //static 是为了使单例的空间共享
    //保证这个方法不会被重写，重载
    public static final LazyInnerClassSingleton getInstance(){
        //在返回结果以前，一定会先加载内部类
        return LazyHolder.LAZY;
    }

    //默认不加载
    private static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
