package collectionTest.streamTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by user on 2016/11/7.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("fffff");
        list.add("ggggg");
        list.add("hhhhh");
        list.add("iiiii");
        System.out.println(list);
        System.out.println(list.stream().map(String::toUpperCase).collect(Collectors.toList()));
        ArrayList<String> outList = list.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
        //System.out.println(list.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new)));
        System.out.println(outList);
        System.out.println(list.stream().collect(Collectors.joining()).toString());
        list.forEach(ele -> System.out.println(ele.length()));

        String[] inputStr1 = {"aaaa", "bbbbb", "ccccc","ddddd"};
        String[] inputStr2 = {"aaaa", "bbbbb", "ccccc","ddddd"};
        String[] outputStr1 = Arrays.stream(inputStr1)
                .map(String::toUpperCase)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(outputStr1));
        for(String obj : inputStr2){
            System.out.println(obj.toUpperCase());
        }
        System.out.println(Arrays.toString(inputStr2));
        System.out.println(Arrays.stream(inputStr1).collect(Collectors.joining()).toString());

        Integer[] inputNum = {1, 2, 3, 4, 5, 6};
        List<Integer> list2 = Arrays.stream(inputNum).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list2);
        System.out.println(Arrays.toString(Arrays.stream(inputNum).toArray(Integer[] :: new)));
        System.out.println(Arrays.toString(Arrays.stream(inputNum).map(n -> n * n).toArray(Integer[]::new)));
        System.out.println(Arrays.toString(Arrays.stream(inputNum).peek(n -> System.out.println(n)).toArray(Integer[]::new)));
        Arrays.stream(inputNum).forEach(n -> System.out.println(n));
        for (Integer ele : inputNum){
            ele = ele+1;
        }

    }
}
