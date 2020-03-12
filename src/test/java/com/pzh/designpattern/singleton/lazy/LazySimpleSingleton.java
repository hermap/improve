package com.pzh.designpattern.singleton.lazy;

/**
 *描述：简单懒汉式单例模式（线程非安全）
 */
public class LazySimpleSingleton {

    // 声明一个私有变量，外部调用时再进行初始化
    private static LazySimpleSingleton singleton;

    // 构造方法私有化
    private LazySimpleSingleton() {}

    /**
     * 描述：实例方法，向外提供的调用接口
     * @return 简单懒汉式单例对象
     */
    public static LazySimpleSingleton getInstance() {
        if (singleton == null) {
            singleton = new LazySimpleSingleton();
        }
        return singleton;
    }
}
