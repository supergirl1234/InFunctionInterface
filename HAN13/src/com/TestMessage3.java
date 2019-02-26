package com;

/**
 * Author:Fanleilei
 * Created:2019/2/26 0026
 */

//泛型信息存在于编译阶段，运行时会类型擦除
public class TestMessage3<T> {
    private  T message;

    public TestMessage3(T message) {
        this.message = message;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    public static void main(String[] args)  {

        TestMessage3<String> p1=new TestMessage3<>("hello");
        TestMessage3<Integer> p2=new TestMessage3<>(123);

        System.out.println(p1.getClass().getName());//com.TestMessage3
        System.out.println(p2.getClass().getName());//com.TestMessage3

        try {
            ////Java反射机制-在运行时了解对象以及类的信息
            System.out.println(p1.getClass().getDeclaredField("message").getType().getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }

}
