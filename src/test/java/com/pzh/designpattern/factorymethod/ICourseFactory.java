package com.pzh.designpattern.factorymethod;

import com.pzh.designpattern.simplefactory.ICourse;

/**
 * 课程工厂接口
 */
public interface ICourseFactory {
    /**
     * 描述：创建课程
     * @return 课程对象
     */
    ICourse createCourse();
}
