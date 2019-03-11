package com.gupaoedu.vip.singleton;

import com.gupaoedu.vip.singleton.lazy.LazyDoubleCheckSingleton;
import com.gupaoedu.vip.singleton.lazy.LazyInnerClassSingleton;
import com.gupaoedu.vip.singleton.lazy.LazySingleton;
import com.gupaoedu.vip.singleton.register.ContainerSingleton;
import com.gupaoedu.vip.singleton.register.EnumSingleton;
import org.junit.Test;

import java.io.*;

public class SingletonTesst {
    @Test
    public void testHungrySingleton() {
        HungrySingleton instance1 = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }

    @Test
    public void testLazySingleton() {

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                LazySingleton instance = LazySingleton.getInstance();
                System.out.println(instance);
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                LazySingleton instance = LazySingleton.getInstance();
                System.out.println(instance);
            }
        });
        thread2.start();
        System.out.println("end");
    }

    @Test
    public void testDoubleSingleton() {

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
                System.out.println(instance);
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                LazyDoubleCheckSingleton instance = LazyDoubleCheckSingleton.getInstance();
                System.out.println(instance);
            }
        });
        thread2.start();
        System.out.println("end");
    }

    @Test
    public void testInnerClassSingleton() {

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                LazyInnerClassSingleton instance = LazyInnerClassSingleton.getInstance();
                System.out.println(instance);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                LazyInnerClassSingleton instance = LazyInnerClassSingleton.getInstance();
                System.out.println(instance);
            }
        });
        thread1.start();
        thread2.start();
        System.out.println("end");
    }

    @Test
    public void testSerializableSingleton() {
        HungrySingleton instance = HungrySingleton.getInstance();
        try (FileOutputStream fileOutputStream = new FileOutputStream("testSerializableSingleton");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ) {
            System.out.println(instance);
            objectOutputStream.writeObject(instance);
            FileInputStream fileInputStream = new FileInputStream("testSerializableSingleton");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object o = objectInputStream.readObject();
            System.out.println(o);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEnumSingleton() {
        Object instance1 = EnumSingleton.getInstance();
        Object instance2 = EnumSingleton.getInstance();
        System.out.println(instance1 == instance2);
    }

    @Test
    public void testContainerSingleton() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                Object instance = ContainerSingleton.getInstance("com.gupaoedu.vip.singleton.register.ContainerSingleton");
                System.out.println(instance);
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                Object instance2 = ContainerSingleton.getInstance("com.gupaoedu.vip.singleton.register.EnumSingleton");
                System.out.println(instance2);
            }
        });
        thread1.start();
        thread2.start();
        System.out.println("end");
    }

}
