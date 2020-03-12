package com.pzh.designpattern.simplefactory;

/**
 * Created by Herman Peng on 2020/3/8.
 */
public class PythonCourse implements ICourse {
    /**
     * 描述：简单工厂方法接口，记录课程
     */
    @Override
    public void record() {
        System.out.println("记录Python课程");
    }
}
