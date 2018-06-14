package com.example.service;

import com.example.BaotaApplication;
import com.example.constant.CallResult;
import com.example.constant.CaloricLevel;
import com.example.constant.Dish;
import com.example.service.lambda.demo.Apple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.constant.Dish.menu;
import static java.util.stream.Collectors.*;

import java.util.stream.Collectors.*;

/**
 * Created by baota on 2018/4/2.
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ContextConfiguration(classes = BaotaApplication.class)
public class java8Test {

    public static final List<Apple> appleList = Arrays.asList(new Apple(30, "red")
            , new Apple(130, "green"), new Apple(130, "black"));

    @Test
    public void comparatorTest() {

        List<Integer> integers = Arrays.asList(7, 10, 1, 8, 2);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a < b ? -1 : (a > b) ? 1 : 0;
            }
        };
        /*Comparator<Integer> com = (Integer a, Integer b) -> b.compareTo(a);
        Collections.sort(integers, com);*/
        //等价于下面这个
        Collections.sort(integers, (Integer a, Integer b) -> b.compareTo(a));
        //Collections.sort(integers, comparator.reversed());
        System.err.println(integers);
    }

    @Test
    public void functionTest() {

        List<Integer> integers = Arrays.asList(7, 10, 1, 8, 2);
        List<Integer> result = forEach(integers, (Integer integer) -> integer + 100);
        System.err.println(result);
    }

    @Test
    public void flatMapTest() {
        List<Integer> row = Arrays.asList(1, 2, 3);
        List<Integer> clo = Arrays.asList(3, 4);
        //相当于双层嵌套循环
        List<int[]> nubs = row.stream()
                .flatMap(r -> clo.stream()
                        .filter(c -> isaBoolean(r, c))
                        .map((c) -> getInts(r, c))
                )
                .filter(nub -> isaBoolean(nub[0], nub[1]))
                .collect(Collectors.toList());
        nubs.stream().forEach(System.err::println);
        System.err.println(nubs);
    }

    @Test
    public void reduceTest(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Comparator<Integer> com = (a,b)-> a.compareTo(b);
        List<Integer> collect = integers.stream().sorted(com.reversed()).collect(Collectors.toList());
        List<Integer> collect2 = integers.stream().sorted().collect(Collectors.toList());
        Integer sum = integers.stream().reduce(0, Integer::sum);
        Optional<Integer> max = integers.stream().reduce(Integer::max);
        Integer count = integers.stream().map(i -> 1).reduce(0, Integer::sum);
        long count2 = integers.stream().count();
    }

    @Test
    public void collectTest() {
        Map<String, List<Apple>> listMap = appleList.stream()
                .collect(Collectors.groupingBy(Apple::getColor));
        Comparator<Apple> com = Comparator.comparing(Apple::getWeight);
        Optional<Apple> max = appleList.stream().collect(Collectors.maxBy(com));
        Integer totalWeight = appleList.stream().collect(Collectors.summingInt(Apple::getWeight));
        IntSummaryStatistics intSummaryStatistics = appleList.stream()
                .collect(Collectors.summarizingInt(Apple::getWeight));
        double average = intSummaryStatistics.getAverage();
        System.err.println(intSummaryStatistics);

    }

    @Test
    public void reducingTest(){
        String colorStr = appleList.stream()
                .map(Apple::getColor).collect(joining(", "));
        //自定义汇总规约
        String coloeStr2 = appleList.stream()
                .collect(Collectors.reducing("", Apple::getColor, (s1, s2) -> s1 + s2));
        String coloeStr3 = appleList.stream().map(Apple::getColor).reduce("", (s1, s2) -> s1 + s2);
        System.err.println(colorStr+";"+coloeStr2);
    }

    @Test
    public void groupTest(){

        //多级分组。groupby接收 一个分类函数，就是以什么为键来分组，看成一个桶
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishByCaloric =
                menu.stream().collect(groupingBy(Dish::getType,
                groupingBy(dish -> {
                    if (dish.getCalories() < 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() < 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                })));
        Map<CaloricLevel, List<Dish>> caloricLevelListMap = dishByCaloric.get(Dish.Type.FISH);
        List<Dish> dishes = caloricLevelListMap.get(CaloricLevel.NORMAL);
        System.err.println(dishByCaloric);

        //按照子组收集数据
        Map<Dish.Type, Long> dishCount = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));
        Map<Dish.Type, Dish> dishMax = menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(
                maxBy(Comparator.comparing(Dish::getCalories)), Optional::get
        )));
        System.err.println(dishMax);

        //对分组后的转换mapping
        Map<Dish.Type, List<String>> dishMapping = menu.stream()
                .collect(groupingBy(Dish::getType,
                        mapping(dish -> dish.getName(), toList())));
        System.err.println(dishMapping);
    }

    @Test
    public void list2MapTest(){
        //mergeFunction 当key冲突时：(oldValue, newValue) -> newvalue
        Map<Integer, Apple> appleMap =
                appleList.stream().collect(Collectors.toMap(apple -> apple.getWeight(), apple -> apple,(oldValue, newValue) -> oldValue));

        System.err.println("haha");
        System.err.println(appleMap);


        Map<Integer, List<String>> collect = appleList.stream()
                .collect(Collectors.groupingBy(Apple::getWeight, mapping(a -> a.getColor(), Collectors.toList())));

        Map<Integer, Apple> appleMap1 = appleList.stream()
                .collect(Collectors.toMap(p -> p.getWeight(), p -> p, (p, q) -> p));

        System.err.println(appleMap1);


    }

    @Test
    public void predicateTest(){

        Predicate<Apple> predicate =
                apple -> apple.getWeight().equals(30) && apple.getColor().equals("red");
        for (Apple a : appleList) {
            if (predicate.test(a)) {
                System.err.println(a);
            }
        }
        List<Apple> collect = appleList.stream()
                .filter(apple -> predicate.test(apple)).collect(Collectors.toList());

        System.err.println(collect);
    }

    private int[] getInts(Integer r, Integer c) {
        return new int[]{r, c};
    }

    private boolean isaBoolean(Integer r, Integer c) {
        return (r + c) % 3 == 0;
    }

    public List<Integer> forEach(List<Integer> integerList, Function<Integer, Integer> function) {

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer integer : integerList) {

            result.add(function.apply(integer));
        }
        return result;
    }

    @Test
    public void optionalTest(){

        List<String> strList = Arrays.asList("12", "233");

        ArrayList<String> totalList = new ArrayList<>();

        Optional.ofNullable(strList).ifPresent(s ->
        {
            List<String> collect = s.stream().filter(l -> l.equals("12")).collect(Collectors.toList());
            System.err.println(collect);
        });

        Optional<Apple> appleOptional = appleList.stream()
                .filter(apple -> apple.getColor().equals("red")).findFirst();

        if (appleOptional.isPresent()) {

            System.err.println(appleOptional.get());
        }
    }


    @Test
    public void mapTest(){

        ArrayList<String> strList = new ArrayList<>();

        List<Apple> appleList = java8Test.appleList.stream().filter(a -> a.getColor().equals("red"))
                .map(Apple::getColor)
                .map(color -> {
                            Apple apple = new Apple();
                            apple.setColor(color);
                            return apple;
                        })
                .collect(Collectors.toList());
    }

    @Test
    public void stringJoinTest(){

        List<String> strings = Arrays.asList("a,a", "c,d");
        String collect = strings.stream().collect(Collectors.joining(","));
        List<String> strings1 = Arrays.asList(collect.split(","));

        Map<String, Integer> collect1 = strings1.stream().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        List<String> collect2 = strings1.stream()
                .collect(Collectors.toMap(e -> e, e -> 1, Integer::sum))
                .entrySet().stream()                   // 所有 entry 对应的 Stream
                .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey())          // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList());
        System.err.println(collect);
    }
}
