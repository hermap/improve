package com.pzh.designpattern.factorymethod;

import com.pzh.designpattern.simplefactory.ICourse;
import com.pzh.designpattern.simplefactory.PythonCourse;

public class PythonCourseFactory implements ICourseFactory {
    /**
     * 描述：创建Python课程
     * @return 课程对象
     */
    @Override
    public ICourse createCourse() {
        return new PythonCourse();
    }
}
