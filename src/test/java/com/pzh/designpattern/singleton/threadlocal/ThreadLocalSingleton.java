package com.pzh.designpattern.singleton.threadlocal;

/**
 * 描述：ThreadLocal 式单例模式
 * Created by Herman Peng on 2020/3/11.
 */
public class ThreadLocalSingleton {
    // 初始化方法initialValue 创建实例对象
    private final static ThreadLocal<ThreadLocalSingleton> instance = new InheritableThreadLocal<ThreadLocalSingleton>() {
        @Override
        protected ThreadLocalSingleton initialValue() {
            return new ThreadLocalSingleton();
        }
    };
    // 构造方法私有化
    private ThreadLocalSingleton() {}

    // 提供一个全局访问点
    public static ThreadLocalSingleton getInstance() {
        return instance.get();
    }
}
