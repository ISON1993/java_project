package javaBase.test.randomTest;

import java.util.Random;

/**
 * Created by user on 2016/10/30.
 */
public class RandomTest {
    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("rand.nextBoolean:" + rand.nextBoolean());
        System.out.println("rand.nextInt:" + rand.nextInt());
        System.out.println("rand.nextInt:" + rand.nextInt(2));
        System.out.println("rand.nextFloat:" + rand.nextFloat());
        System.out.println("rand.nextDouble:" + rand.nextDouble());
        System.out.println("rand.nextDouble:" + rand.nextDouble());
    }
}
