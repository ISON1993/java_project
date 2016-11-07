package collectionTest.IteratorTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by user on 2016/11/6.
 */
public class IteratorError {
    public static void main(String[] args) {
        Collection books = new ArrayList();
        books.add("book1");
        books.add("book2");
        books.add("book3");
        books.add("book4");
        System.out.println("/***************************************************/");
        for(Object book : books){
            System.out.println(book);
        }
        System.out.println("/***************************************************/");
        books.forEach(obj -> System.out.println(obj));
        System.out.println("/***************************************************/");
        Iterator it = books.iterator();
        while(it.hasNext()){
            String book = (String)it.next();
            if(book == "book1"){
//                books.remove(book);
                it.remove();
            }
        }
        books.forEach(obj -> System.out.println(obj));
    }
}
