package genericity;

import jdk.nashorn.internal.objects.annotations.Setter;

class Fruit {}

class Banana extends Fruit {}


/**
 * Created by tuzhenyu on 16-11-25.
 */
public class WrapAndConvert {
    public static void main(String[] args) {
//        Apple<Integer> apple = new Apple<>(6);
//        System.out.println(apple.getSize().getClass());
//
//        Apple test = new Apple(1);
//        System.out.println(test.getSize());
////        Integer a = test.getSize();
//        Apple b = test;
//        System.out.println(b.getSize().getClass());
////        Integer c = b.getSize();

        Fruit fruit = new Banana();
        System.out.println(fruit.getClass());
        System.out.println(fruit instanceof Fruit);
    }
}

class Apple<T extends Number>{
    private T size;
    public Apple(){}

    public Apple(T size){
        this.size = size;
    }

    public void setSize(T size){
        this.size = size;
    }

    public T getSize(){
        return  this.size;
    }
}
