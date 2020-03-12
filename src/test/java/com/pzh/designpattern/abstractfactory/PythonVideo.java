package com.pzh.designpattern.abstractfactory;

/**
 * Created by Herman Peng on 2020/3/8.
 */
public class PythonVideo implements IVideo {
    @Override
    public void record() {
        System.out.println("Python 视频");
    }
}
