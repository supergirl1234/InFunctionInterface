package com;

/**
 * Author:Fanleilei
 * Created:2019/2/26 0026
 */
public class TestMessage {

    public  static  void fun(Message<String> message){
        System.out.println(message.getMessage());

    }

    //泛型参数 ？ 通配符解决参数统一的问题

    public static void fun2(Message<?> message){
        System.out.println(message.getMessage());

    }

    //泛型上限  只能够设置本类及其子类
    public static void fun3(Message<? extends Number> message){
        System.out.println(message.getMessage());

    }
    //泛型下限  只能够设置本类及其父类
    public static void fun4(Message<? super String > message){
        System.out.println(message.getMessage());

    }


    public static void main(String[] args) {

        Message<String> p1=new Message<>("我是人");
        fun(p1);

        Message<Integer> p2=new Message<>(12);
        //fun(p2);//error,因为fun方法只接收String类型的Message对象

        fun2(p1);
        fun2(p2);

        //泛型上限
        Message1<Number> t1=new Message1<>();
        Message1<Integer> t2=new Message1<>();
        //Message1<String> t3=new Message1<>();//error,因为Message1 的泛型上限是Number，只能够设置Number或其子类
}
}

class Message<T>{

    private T message;

    public Message(T message) {
        this.message = message;
    }

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}


//泛型上限
class Message1<T extends  Number>{

    private  T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
