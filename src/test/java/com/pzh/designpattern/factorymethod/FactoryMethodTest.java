package com.pzh.designpattern.factorymethod;

public class FactoryMethodTest {
    public static void main(String[] args) {
        // 实例化具体的子类实现工厂，然后通过具体工厂创建课程，调用课程内容
//        ICourseFactory factory = new JavaCourseFactory();
        ICourseFactory factory = new PythonCourseFactory();
        factory.createCourse().record();
    }
}
