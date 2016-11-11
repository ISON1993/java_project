package javaBase.LambdaTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by user on 2016/11/6.
 */
public class LambdaTest {
    public static void main(String[] args) {
        Collection books = new ArrayList();
        books.add("book1");
        books.add("book2");
        books.add("book3");
        books.add("book4");
        System.out.println("/*******************************/");
        System.out.println(count(books, ele -> (((String) ele).length() > 2)));
        System.out.println("/*******************************/");
        printBooks(books, ele -> System.out.println(ele));
        System.out.println("/*******************************/");
        printBooksTest(books, ele -> System.out.println(ele));
    }
    public static int count(Collection books,Predicate p){
        int total = 0;
        for(Object book : books){
            if(p.test(book)){
                total++;
            }
        }
        return total;
    }
    public static void printBooks(Collection books,Consumer action){
        for (Object book : books){
            action.accept(book);
        }
    }

    public static void printBooksTest(Collection books,Test t){
        for (Object book : books){
            t.accept(book);
        }
    }
}
