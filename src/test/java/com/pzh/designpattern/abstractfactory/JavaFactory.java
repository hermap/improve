package com.pzh.designpattern.abstractfactory;

/**
 * Created by Herman Peng on 2020/3/8.
 */
public class JavaFactory extends IFactory {

    @Override
    public INote createNote() {
        return new JavaNote();
    }

    @Override
    public IVideo createVideo() {
        return new JavaVideo();
    }
}
