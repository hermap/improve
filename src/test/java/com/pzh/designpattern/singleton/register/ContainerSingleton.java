package com.pzh.designpattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述：容器式单例模式（类IoC容器写法）
 * Created by Herman Peng on 2020/3/11.
 */
public class ContainerSingleton {
    private static Map<String,ContainerSingleton> container = new ConcurrentHashMap<>();

    private ContainerSingleton() {}

    /**
     * 描述：返回单例实例
     * @param clazz 类对象
     * @return 单例实例
     */
    public static ContainerSingleton getInstance(Class<? extends ContainerSingleton> clazz) {
        String className = clazz.getName();
        if (container.containsKey(className)) {
            return container.get(className);
        } else {
            ContainerSingleton singleton = null;
            try {
                singleton =  clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            container.put(className, singleton);
            return singleton;
        }
    }

    /**
     * 描述：返回单例实例
     * @param className 类名称
     * @return 单例实例
     */
    public static ContainerSingleton getInstance(String className) {
        if (container.containsKey(className)) {
            return container.get(className);
        } else {
            ContainerSingleton singleton = null;
            try {
                singleton = (ContainerSingleton) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            container.put(className, singleton);
            return singleton;
        }
    }
}
