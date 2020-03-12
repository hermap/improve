package com.pzh.designpattern.singleton.lazy;

/**
 * 描述：双重检查
 * 优点：线程安全，保证线程安全的同时能提高性能
 * 缺点：代码可读性变差，不够优雅
 * Created by Herman Peng on 2020/3/11.
 */
public class LazyDoubleCheckSingleton {
    // 声明一个私有变量，外部调用时再进行初始化
    // 加上 volatile 关键字，用于解决指令重排序问题（内存屏障）
    private static volatile LazyDoubleCheckSingleton singleton;

    // 构造方法私有化
    private LazyDoubleCheckSingleton() {}

    /**
     * 描述：实例方法，向外提供的调用接口
     * @return 双重检查单例对象
     */
    public static LazyDoubleCheckSingleton getInstance() {
        // 第一次进入时，此时多线程环境下不安全
        if (singleton == null) {
            // 加锁操作
            synchronized (LazyDoubleCheckSingleton.class) {
                // 再次判断是因为当之前的线程运行完成释放锁后，不加该判断会导致对象覆盖
                if (singleton == null) {
                    //因为编译器或cpu优化原因,可能会产生重排序问题,因此需给属性加上volatile关键字
                    singleton = new LazyDoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
