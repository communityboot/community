package com.muchi.community.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/9/26   10:33
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class lambdaTest {


    @Test
    public void test() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> strings = Arrays.asList(atp);
        Predicate<String> lengthFilter=(p) ->(p.length()>10);
        System.out.println("过滤输出----------->start");
        Arrays.stream(atp).filter((p)->(p.length()>20)).forEach((System.out::println));
        System.out.println("过滤输出------>end");
        // 以前的循环方式
        for (String player : strings) {
           // System.out.print(player + "; ");
        }
        // 使用 lambda 表达式以及函数操作(functional operation)
        strings.forEach((System.out::println));
        // 在 Java 8 中使用双冒号操作符(double colon operator)
        strings.forEach(System.out::println);
    }

    @Test
    public void testTwo(){

        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

        // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1.compareTo(s2));
            }
        });
        System.out.println(players);
// 1.2 使用 lambda expression 排序 players
        Comparator<String> sortByName = Comparator.naturalOrder();
        Arrays.sort(players, sortByName);

// 1.3 也可以采用如下形式:
        Arrays.sort(players, String::compareTo);
    }


}
