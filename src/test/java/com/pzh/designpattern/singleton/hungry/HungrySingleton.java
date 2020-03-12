package com.pzh.designpattern.singleton.hungry;

import java.io.Serializable;

/**
 * 描述：饿汉式单例模式
 */
public class HungrySingleton implements Serializable {
    // 声明为static，类加载的时候进行初始化
    private static HungrySingleton singleton = new HungrySingleton();

    // 构造函数私有，外部引用不能直接new对象（反射除外）
    private HungrySingleton(){}

    // 提供一个对外访问的方法
    public static HungrySingleton getInstance() {
        return singleton;
    }

    /**
     * 描述：重写方法，保证序列化之后仍是单例
     * @return 单例实例对象
     */
    private Object readResolve() {
        return singleton;
    }
}
