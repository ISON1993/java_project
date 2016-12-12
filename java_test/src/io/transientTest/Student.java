package io.transientTest;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by tuzhenyu on 16-12-12.
 */
@Setter
@Getter
public class Student implements Serializable{
    private String name;
    private transient int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

     private void writeObject(java.io.ObjectOutputStream s)
            throws java.io.IOException {
        s.defaultWriteObject();
        s.writeInt(age);
    }


    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException {
        s.defaultReadObject();
        this.age = s.readInt(); // ignored
    }
}
