package com.pzh.designpattern.singleton;

import com.pzh.designpattern.pojo.Student;
import com.pzh.designpattern.singleton.hungry.HungrySingleton;
import com.pzh.designpattern.singleton.register.EnumSingleton;

import java.io.*;

/**
 *Created by Herman Peng on 2020/3/11.
 */
public class SerializableSingletonTest {
    public static void main(String[] args) {
        testHungerSingletonSerializable();
    }

    public static void testHungerSingletonSerializable() {
        try {
            HungrySingleton instance = HungrySingleton.getInstance();
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sutdent.obj"));
            out.writeObject(instance);
            out.flush();
            out.close();
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("sutdent.obj"));
            HungrySingleton hungrySingleton = (HungrySingleton) input.readObject();
            input.close();
            System.out.println(hungrySingleton == instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void testEnumSerializable() {
        try {
            EnumSingleton instance = EnumSingleton.getInstance();
            Student student = new Student(10001, "Herman Peng", "17862000000", "no",null);
            instance.setData(student);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sutdent.obj"));
            out.writeObject(instance);
            out.flush();
            out.close();
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("sutdent.obj"));
            EnumSingleton stu = (EnumSingleton) input.readObject();
            input.close();
            System.out.println(stu == instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
