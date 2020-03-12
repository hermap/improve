package com.pzh.designpattern.singleton.lazy;

/**
 * 描述：加锁的懒汉式单例模式
 * 优点：节约内存，线程安全
 * 缺点：性能较差
 * Created by Herman Peng on 2020/3/11.
 */
public class SyncSingleton {
    private static SyncSingleton singleton;
    // 构造方法私有化
    private SyncSingleton() {}
    // 提供对外访问入口，方法加锁，线程安全
    public static synchronized SyncSingleton getInstance() {
        if (singleton == null) {
            singleton = new SyncSingleton();
        }
        return  singleton;
    }

    // 提供对外访问入口，对象加锁（此处与方法加锁一致，其他情况下可在加锁对象前后做逻辑处理），线程安全
    public static SyncSingleton getInstance2() {
        synchronized (SyncSingleton.class) {
            if (singleton == null) {
                singleton = new SyncSingleton();
            }
        }
        return  singleton;
    }
}
