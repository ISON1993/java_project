package io.objectOutputStreamTest;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by tuzhenyu on 16-12-12.
 */
@Setter
@Getter
public class Person implements Serializable{
    private String name;
    private int age;

    public Person(String name,int age){
        System.out.println("person构造器");
        this.name = name;
        this.age = age;
    }
}
