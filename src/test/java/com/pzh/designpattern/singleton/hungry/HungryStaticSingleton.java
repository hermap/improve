package com.pzh.designpattern.singleton.hungry;

/**
 * 描述：饿汉式单例模式（静态式）
 */
public class HungryStaticSingleton {
    /*
    * 类初始化过程中的加载顺序：先静态，后动态；先属性，后方法；先上，后下
    */
    // 声明为static，静态块中进行初始化,final 修饰符可选
    private static final HungryStaticSingleton singleton;
    // 静态块初始化
    static {
        singleton = new HungryStaticSingleton();
    }

    // 构造函数私有，外部引用不能直接new对象（反射除外）
    private HungryStaticSingleton(){}

    // 提供一个对外访问的方法
    public static HungryStaticSingleton getInstance() {
        return singleton;
    }
}
