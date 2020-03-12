package com.pzh.designpattern.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 描述：student 对象，用作序列化测试或是其他
 * Created by Herman Peng on 2020/3/11.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Student implements Serializable, Cloneable {
    private Integer id;
    private String name;
    private String phone;
    private String note;
    private Course course;

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}
