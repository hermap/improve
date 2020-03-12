package com.pzh.designpattern.abstractfactory;

/**
 * Created by Herman Peng on 2020/3/8.
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        IFactory factory = new JavaFactory();
        factory.createNote().note();
        factory.createVideo().record();
    }

}
