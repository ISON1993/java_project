package collectionTest.examples;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by user on 2016/11/10.
 */
class Student{
    private String name;
    private int age;

    public Student(String name , int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        else if (obj!=null && this.getClass() == obj.getClass()){
            Student s = (Student)obj;
            return (this.name == s.getName() && this.age == s.getAge());
        }
        else{
            return false;
        }
    }
    public int hashCode(){
        return this.age * 37 + this.name.hashCode();
    }
}
public class HashMapTest {
    public static void main(String[] args) {
        Map hm = new HashMap<>();
        hm.put(new Student("zjd",12),"shandong");
        hm.put(new Student("zxm",12),"shandong");
        hm.put(new Student("zjn",12),"shandong");
        hm.put(new Student("dxm",12),"shandong");
        hm.put(new Student("wyj",12),"shandong");
        hm.put(new Student("zxz",12),"shandong");
        hm.put(new Student("zjj",12),"shandong");
        hm.put(new Student("zjd",12),"shandong");
        hm.put(new Student("zjn",12),"shandong");
        hm.put(new Student("dxm",12),"shandong");
        hm.put(new Student("wyj", 12), "shandong");

        Set<Map.Entry<Student,String>> infoSet = hm.entrySet();
        System.out.println(infoSet);
        infoSet.stream().forEach(ele -> System.out.println(ele.getKey().getName()));
    }
}
