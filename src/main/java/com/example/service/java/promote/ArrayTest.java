package com.example.service.java.promote;


import com.example.service.extend.Person;
import com.example.service.spring.boot.demo.beanExtends.HelloWorld;
import org.springframework.security.access.method.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by duguangquan on 2018/9/2.
 */
public class ArrayTest {


    /**
     * Arrays工具类的坑
     * 1.public static <T> List<T> asList(T... a)，传入数组，那么长度会是1；
     * 注意这个参数:T...a，这个参数是一个泛型的变长参数，我们知道基本数据类型是不可能泛型化的，
     * 也是就说 8 个基本数据类型是不可作为泛型参数的，但是为什么编译器没有报错呢?这是因为在 Java 中，
     * 数组会当做一个 对象来处理，它是可以泛型的。
     *
     * 2.Arrays.asList()返回的list是arrays的一个内部类，并没有add（），所以不可以改变，并不是java.util.arrayList,
     * 所以综上所述，asList 返回的是一个长度不可变的列表。
     * 数组是多长，转换成的列表是多长，我们是无法通过 add、remove 来增加或者减少其长度的。
     *
     * 3.Arrays.toArray:转换为数组，实现了数组的浅拷贝。
     */
    public  static void arraysTest(){

        int[] datas = new int[]{1,2,3,4,5};
        List list = Arrays.asList(datas);
        System.out.println(list.size());



        List<String> strings = Arrays.asList("1", "2", "3");
        int a = 9;

        List<Integer> integers = Arrays.asList(a);
        System.err.println(integers);
        int size = strings.size();
        strings.set(1,"hh");

        strings.add("9");

    }

    /**
     * 浅拷贝
     */
    public static void lowCopyTest(){

        //List<String> oldList = Arrays.asList("1", "2", "3");
        List<Person> oldList = new ArrayList<>();
        oldList.add(new Person("1"));
        oldList.add(new Person("2"));
        List<Person> newList = new ArrayList<>();
        newList.addAll(oldList);
        newList.get(1).setName("baota");
        System.err.println(oldList);


    }

    /**
     * ArrayList 实现不是同步的。如果多个线程同时访问一个 ArrayList 实例，而其中至少一个线程从结构上修 改了列表，
     * 那么它必须保持外部同步。所以为了保证同步，最好的办法是在创建时完成，以防止意外对列表进行 不同步的访问
     */
    public static void synchronizedList(){

        int[] intArr = new int[]{1,2};
        List<int[]> intList = Arrays.asList(intArr);
        Object[] objects1 = intList.toArray();

        List<Person> str = Arrays.asList(new Person("1"),new Person("2"));

        Person person = new Person("1");
        Person person2 = str.get(0);
        str.remove(person2);

        ArrayList<Person> realList = new ArrayList<>();
        realList.add(new Person("1"));
        Person person1 = realList.get(0);
        realList.remove(person1);

        Integer a = 9;
        a.equals(9);
        String bb = "baota";
        bb.equals("ll");

        System.err.println(str);
        Object[] objects = str.toArray();
        objects[1] =objects[0];
        System.err.println(str);

        //List<String> synchronizedList = Collections.synchronizedList(str);

    }


    /**
     * subList()的keng
     * 1.subList 返回的只是原列表的一个视图，它所有的操作最终都会作用在原列表上
     * 2.对于子列表视图，它是动态生成的，生成之后就不要操作原列表了，否则必然都导致视图的不稳定而抛出异
     常。最好的办法就是将原列表设置为只读状态，要操作就操作子列表
     */
    public static void subListTest(){




        /**
         * compareTo 是判断元素在排序中的位置是否相等，eq uals 是判断元素是否相等，既然一个决定排序位置，一个决定相等，
         * 所以我们非常有必要确保当排序位置相同 时，其 equals 也应该相等。
         * 实现了 compareTo 方法，就有必要实现 equals 方法，同时还需要确保两个方法同步
         */
        Integer a = 2;
        a.compareTo(3);


        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);

        List<Integer> subList = list1.subList(0, list1.size());
        subList.add(3);

        boolean result = list1.equals(subList);


        //最好的办法就是将原列表设置为只读状态
        list1 = Collections.unmodifiableList(list1);

        //抛出 ConcurrentModificationException 异常
        list1.add(4);
        subList.size();
    }

    public static String listTest(List<String> codes){

        String s = codes.get(0);
        System.err.println(s);
        return "";


    }

    public static void main(String[] args) {

        listTest(Arrays.asList("bota"));

        HelloWorld helloWorld = new HelloWorld();
        String path = helloWorld.getClass().getResource("/").getPath();
        System.err.println("");

        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("d");

        Map<String, Integer> collect = list.stream().collect(Collectors.toMap(p -> p, p -> list.indexOf(p), (p, q) -> p));

        List<Integer> collect1 = IntStream.rangeClosed(0, list.size() - 1).boxed().collect(Collectors.toList());

        Map<String, Integer> collect2 = IntStream.rangeClosed(0, list.size() - 1).boxed()
                .collect(Collectors.toMap(p -> list.get(p), Function.identity()));


        System.err.println(collect);


        subListTest();

        synchronizedList();


        Person baota = new Person("baota");

        Person baota2 = baota;

        baota.setName("haha");
        System.err.println(baota2);



       // lowCopyTest();

        arraysTest();

        int[] array = new int[]{1,2,3,4};


        long time1 = System.currentTimeMillis();
        int[] intArr = new int[1000];
        for (int i=0; i<1000;i++){
            intArr[i]=i;
        }

        int sum =0;
       for (int i=0;i<1000;i++){
           sum =+ intArr[i];
       }

        long time2 = System.currentTimeMillis();
        System.err.println("求和时间：" + (time2 - time1));
    }
}
