package com.pzh.designpattern.simplefactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
//        ICourse course = new CourseFactory().createCourse("java");
//        ICourse course = new CourseFactory().createCourseByClassName("com.pzh.designpattern.simplefactory.JavaCourse");
        ICourse course = new CourseFactory().createCourse(PythonCourse.class);
        if (course != null) {
            course.record();
        } else {
            System.out.println("无课程可以记录！");
        }

    }
}
