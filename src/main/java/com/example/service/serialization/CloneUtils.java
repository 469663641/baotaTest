package com.example.service.serialization;

import com.example.service.extend.Person;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by duguangquan on 2018/8/19.
 */
/*
把母对象写入到一个字节流中，再从字节流中将其读出来，这样就可以创建一个新的对象了，
并且该新对象与母对象之间并不存在引用共享的问题，真正实现对象的深拷贝
*/
public class CloneUtils {

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj){
        T cloneObj = null;
        try {
            //写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();
            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            //返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) { e.printStackTrace();
        }
        return cloneObj; }


    public static void main(String[] args) {


        Person person = new Person("baota");
        person.setAge(18);

        Person person2 = clone(person);
        System.err.println(person2);
        person2.setName("baota2");
        System.err.println(person2);
    }
}
