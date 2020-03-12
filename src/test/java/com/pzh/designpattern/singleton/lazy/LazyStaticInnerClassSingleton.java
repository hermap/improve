package com.pzh.designpattern.singleton.lazy;

/**
 * 描述：静态内部类单例模式
 * 优点：性能高，线程安全，代码优雅，完美利用了java语法内容（类加载）
 * 缺点：能被反射破坏（上述各种懒汉式和饿汉式也能被破坏）
 * Created by Herman Peng on 2020/3/11.
 */
public class LazyStaticInnerClassSingleton {

    // 构造方法私有,防止反射破坏型
    private LazyStaticInnerClassSingleton() {
        if (LazyHolder.INSTANCE != null) {
            throw new RuntimeException("不予许通过其他方式非法访问！");
        }
    }

    public static LazyStaticInnerClassSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * 类加载时，会从 classpath 路径下扫描class文件，然后进行加载
     * classpath： LazyStaticInnerClassSingleton.class
     *             LazyStaticInnerClassSingleton$LazyHolder.class
     * 该类中，只会加载 LazyStaticInnerClassSingleton.class ，等用到了 LazyHolder.class，才会加载后者。
     */
    private static class LazyHolder {
        private static LazyStaticInnerClassSingleton INSTANCE = new LazyStaticInnerClassSingleton();
    }
}
