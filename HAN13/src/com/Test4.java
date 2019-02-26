package com;

import java.util.Collections;
import java.util.function.*;

/**
 * Author:Fanleilei
 * Created:2019/2/26 0026
 */
public class Test4 {

    public static void main(String[] args) {

        //功能型函数接口

       /* Function<Object,String> p1=new Function<Object, String>() {
            @Override
            public String apply(Object o) {
                return o.toString();
            }
        };*/

        Function<Object,String> p1= o -> o.toString();
        System.out.println(p1.apply("hello"));

        Function<Integer,String> p2=String::valueOf;
        System.out.println(p2.apply(10));

        //参数确定，返回值类型不确定
        IntFunction<String> intFunction=String::valueOf;
        System.out.println(intFunction.apply(100));


        IntFunction<Long> intFunction2 = Integer::toUnsignedLong;
        System.out.println(intFunction2.apply(222));


        System.out.println("-------------------------");

        //供给型函数接口
        Supplier<String> t="Hello"::toUpperCase;
        System.out.println(t.get());

        Supplier<Integer> t2=new Supplier<Integer>() {
            @Override
            public Integer get() {
                return 123;
            }
        };

        t2.get();

        System.out.println("----------------------");



        //功能型函数与供给型函数结合使用
        //y=f(x)
        //x=g(x)

        /*Function<Supplier<Integer>,String> r=new Function<Supplier<Integer>, String>() {
            @Override
            public String apply(Supplier<Integer> integerSupplier) {
                return integerSupplier.toString();
            }
        };
       Supplier<Integer> w=new Supplier<Integer>() {
           @Override
           public Integer get() {
               return 123;
           }
       };


        System.out.println(r.apply(w));
*/

        Function<Supplier<Person>,String> r=new Function<Supplier<Person>, String>() {
            @Override
            public String apply(Supplier<Person> integerSupplier) {
                return integerSupplier.toString();
            }
        };
        Supplier<Person> w=new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person("张三",12);
            }
        };


        System.out.println(r.apply(w));


        System.out.println("----------------");

        //消费型函数
        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("qjjs");

        /*Consumer<String[]> consumer1=new Consumer<String[]>() {
            @Override
            public void accept(String[] strings) {
                for(String item:strings){
                    System.out.println(item);

                }
            }
        };*/
        Consumer<String[]> consumer1= strings -> {
            for(String item:strings){
                System.out.println(item);

            }
        };
        consumer1.accept(new String[]{"a","b","c"});

        System.out.println("----------  ");

        //断言型函数
        Predicate<String>  predicate=new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return  s=="sd";
            }
        };

        System.out.println(predicate.test("1"));

        Predicate<String> predicate2 = "Hello"::endsWith;
        boolean rs = predicate2.test("o"); // "Hello".endsWith("o");
        System.out.println(rs);

        //参数 Object 类型，判断 如果参数对象是由Person类实例化的，return true 否则 false
        Predicate<Object> q=obj->{

            return obj instanceof Person;
        };
        System.out.println(q.test("hello"));//false
        System.out.println(q.test(new Person("长撒",12)));//true


    }
}

class Person{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
