package com;

/**
 * Author:Fanleilei
 * Created:2019/2/26 0026
 */


interface  IMessage<T>{//泛型接口
    void print(T t);



}
public class TestMessage2 {

    public static void main(String[] args) {

        IMessage<String> p1=new IMessage<String>() {
            @Override
            public void print(String s) {
                System.out.println(s);
            }
        };

      p1.print("hello");

        System.out.println("-----------------");

        IM<String> t= new IM<>();
        t.print("we");

        IMM r=new IMM(12);
        r.print("ke");

        System.out.println("----------------- ");




    }
}

//子类继续保留泛型参数
class IM<T> implements IMessage<T>{



    @Override
    public void print(T t) {
        System.out.println("子类"+t);
    }
}

//指定泛型参数的类型
class IMM implements IMessage<String>{

    private  int age;

    public IMM(int age) {
        this.age = age;
    }

    @Override
    public void print(String s) {
        System.out.println("子类2"+s);
    }
}
