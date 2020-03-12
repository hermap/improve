package com.pzh.designpattern.simplefactory;

public class JavaCourse implements ICourse {
    /**
     * 描述：简单工厂方法接口，记录课程
     */
    @Override
    public void record() {
        System.out.println("记录Java课程");
    }
}
