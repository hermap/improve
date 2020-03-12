package com.pzh.designpattern.singleton;

import com.pzh.designpattern.singleton.lazy.LazySimpleSingleton;

/**
 * 描述：简单懒汉式单例等非线程安全调试
 *Created by Herman Peng on 2020/3/11.
 */
public class ThreadExecutor implements Runnable {
    /**
     * 调用简单懒汉式单例模式，进行线程非安全调试
     */
    @Override
    public void run() {
        LazySimpleSingleton instance = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ": " + instance);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadExecutor());
        Thread t2 = new Thread(new ThreadExecutor());
        t1.start();
        t2.start();
        System.out.println("End");
    }
}
