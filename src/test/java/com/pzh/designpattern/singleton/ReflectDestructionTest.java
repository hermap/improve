package com.pzh.designpattern.singleton;

import com.pzh.designpattern.singleton.lazy.LazyDoubleCheckSingleton;
import com.pzh.designpattern.singleton.lazy.LazyStaticInnerClassSingleton;

import java.lang.reflect.Constructor;

/**
 * 描述：通过反射破坏单例
 * Created by Herman Peng on 2020/3/11.
 */
public class ReflectDestructionTest {
    public static void main(String[] args) {
//        testCannotReflectDestruction();
        testCanReflectDestruction();
    }

    public static void testCannotReflectDestruction() {
        Class<LazyStaticInnerClassSingleton> aClass = LazyStaticInnerClassSingleton.class;
        try {
            LazyStaticInnerClassSingleton s1 = LazyStaticInnerClassSingleton.getInstance();
            System.out.println(s1);
            Constructor<LazyStaticInnerClassSingleton> c = aClass.getDeclaredConstructor(null);
            c.setAccessible(true);
            LazyStaticInnerClassSingleton s2 = c.newInstance();
            System.out.println(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testCanReflectDestruction() {
        Class<LazyDoubleCheckSingleton> singletonClass = LazyDoubleCheckSingleton.class;
        try {
            Constructor<LazyDoubleCheckSingleton> c = singletonClass.getDeclaredConstructor(null);
            c.setAccessible(true);
            LazyDoubleCheckSingleton s1 = c.newInstance();
            LazyDoubleCheckSingleton s2 = c.newInstance();
            LazyDoubleCheckSingleton s3 = LazyDoubleCheckSingleton.getInstance();
            LazyDoubleCheckSingleton s4 = LazyDoubleCheckSingleton.getInstance();
            System.out.println(s1);
            System.out.println(s2);
            System.out.println(s3);
            System.out.println(s4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
