package com.example.service.extend;

import com.example.common.BaseDomain;

/**
 * Created by duguangquan on 2018/8/19.
 */
public class Person extends BaseDomain{

    /**
     * 1、它只能调用 static 变量。
     2、它只能调用 static 方法。
     3、不能以任何形式引用 this、super。
     4、static 变量在定义时必须要进行初始化，且初始化时间要早于非静态变量。
     总结:无论是变量，方法，还是代码块，只要用 static 修饰，就是在类被加载时就已经”准备好了”,
     也就是可以 被使用或者已经被执行，都可以脱离对象而执行。反之，如果没有 static，则必须要依赖于对象实例。
     */
    public static final Integer b =  8;

    private static final long serialVersionUID = 5183699686059151485L;

    protected String name;
    protected int age;
    protected String sex;

    /**
     * 编译器会 将代码块按照他们的顺序(假如有多个代码块)插入到所有的构造函数的最前端，这样就能保证不管调用哪个构造函 数都会执行所有的构造代码块
     */
    {
        this.age = 18;
    }


    //有参数的构造函数
    public Person(String name) {

        this.name = name;
        System.err.println(name);
    }

    public Person(){

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

     void test(){
        System.err.println("person");

    }

    public static void main(String[] args) {
        Person baota = new Person("baota");

        System.err.println(baota);
    }
}
