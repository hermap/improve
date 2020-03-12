package com.pzh.designpattern.singleton.register;

import java.io.Serializable;

/**
 * 描述：枚举类型注册时单例
 * 优点：代码简洁优雅，线程安全，反射不可破坏
 * 缺点：序列化/反序列化会破坏·
 * Created by Herman Peng on 2020/3/11.
 */
public enum EnumSingleton implements Serializable {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 同static类似，加载时将会被放置在内存中，所以是线程安全的
     * @return 枚举实例
     */
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
