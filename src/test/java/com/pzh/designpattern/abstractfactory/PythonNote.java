package com.pzh.designpattern.abstractfactory;

/**
 * Created by Herman Peng on 2020/3/8.
 */
public class PythonNote implements INote {
    @Override
    public void note() {
        System.out.println("Python 笔记");
    }
}
