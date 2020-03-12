package com.pzh.designpattern.factorymethod;

import com.pzh.designpattern.simplefactory.ICourse;
import com.pzh.designpattern.simplefactory.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {
    /**
     * 描述：创建Java课程
     * @return 课程对象
     */
    @Override
    public ICourse createCourse() {
        return new JavaCourse();
    }
}
