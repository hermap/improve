package com.pzh.designpattern.abstractfactory;

/**
 * Created by Herman Peng on 2020/3/8.
 */
public abstract class IFactory {
    public void init() {
        System.out.println("初始化数据");
    }

    public abstract INote createNote();

    public abstract IVideo createVideo();
}
