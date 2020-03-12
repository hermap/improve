package com.pzh.designpattern.prototype;

import com.pzh.designpattern.pojo.Course;
import com.pzh.designpattern.pojo.Student;

import java.io.*;

/**
 * 描述：原型设计模式深拷贝（可以设计成工具类）
 * 实现Cloneable接口的对象都可以进行浅拷贝，当拷贝对象中含有引用数据类型时，该引用拷贝的是引用地址而非对象本身</br>
 * 也就是说，对拷贝对象改变引用值之后，原对象的该引用对象也会发生改变
 * Created by Herman Peng on 2020/3/12.
 */
public class PrototypePattern {
    /**
     * 实现对象的深拷贝（通过序列化的方式，被拷贝对象需要实现序列化接口）
     * @param object 被拷贝的对象
     * @return 返回新的拷贝对象（非简单类型hashCode值将发生改变）
     */
    @SuppressWarnings("unchecked")
    public static <T>T deepClone(T object) {
        if (object == null) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            // 序列化方式将对象写到内存中
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.flush();
            oos.close();
            // 反序列化方式从内存中加载对象，并转换成其原来的形式。
            ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            return (T) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (oos != null) {
                    oos.close();
                }
                baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 描述：测试深克隆
     * @param args 参数
     */
    public static void main(String[] args) {
        Course course = new Course(1001,"Java","no","Herman");
        Student student = new Student();
        student.setId(10001).setName("herman Peng").setNote("other").setCourse(course);
        Student deep = PrototypePattern.deepClone(student);
        Student lightClone = null;
        try {
            lightClone = student.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println("浅克隆：" + (lightClone.getCourse() == student.getCourse()));
        System.out.println("深克隆：" + (student.getCourse() == deep.getCourse()));
    }
}
