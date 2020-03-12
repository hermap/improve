package com.pzh.designpattern.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 *Created by Herman Peng on 2020/3/12.
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable, Cloneable {
    private Integer courseId;
    private String courseName;
    private String teacher;
    private String note;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
