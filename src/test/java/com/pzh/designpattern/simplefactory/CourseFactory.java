package com.pzh.designpattern.simplefactory;

import org.springframework.util.StringUtils;

/**
 * 简单工厂模式
 */
public class CourseFactory {

    /**
     * 介绍： V1 版本
     * 描述：根据传入的课程名称返回一个课程实例，目前处理了java和Python两种类型</br>
     * 该类型的缺点很明显，当传入的不是java和Python，就会创建空对象，不能控制好输入
     * @param courseName 课程名称
     * @return 课程实例
     */
    public ICourse createCourse(String courseName) {
        if ("java".equalsIgnoreCase(courseName)) {
            return new JavaCourse();
        } else if ("python".equalsIgnoreCase(courseName)) {
            return new PythonCourse();
        }
        return null;
    }

    /**
     * 介绍： V2 版本
     * 描述：根据传入的课程对象路径返回一个课程实例</br>
     *      该类型比V1版本安全一些，但也可能出现输入参数类路径错误而导致的报错问题。</br>
     *      同时，方法的返回还需要强制转换
     * @param className 课程对象class路径
     * @return 课程实例
     */
    public ICourse createCourseByClassName(String className) {
        if (StringUtils.hasText(className)) {
            try {
                Class<?> aClass = Class.forName(className);
                return (ICourse) aClass.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 介绍：V3版本
     * 描述：通过类信息来返回课程实例，同时限定的类的范围，极大程度上解决了安全性问题
     * @param clazz 课程类对象
     * @return 课程实例
     */
    public ICourse createCourse(Class<? extends ICourse> clazz) {
        if (clazz != null) {
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
