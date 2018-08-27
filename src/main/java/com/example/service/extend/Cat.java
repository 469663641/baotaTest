package com.example.service.extend;

import java.io.Serializable;

/**
 * Created by duguangquan on 2018/8/19.
 */

/*
1.抽象类是对整个类整体进行抽象，包括属性、行 为，但是接口却是对类局部(行为)进行抽象
2.我们知道抽象类是从子类中 发现公共部分，然后泛化成抽象类，子类继承该父类即可，但是接口不同。实现它的子类可以不存在任何关 系，共同之处。
例如猫、狗可以抽象成一个动物类抽象类，具备叫的方法。鸟、飞机可以实现飞 Fly 接口，具备 飞的行为，这里我们总不能将鸟、飞机共用一个父类吧!
所以说抽象类所体现的是一种继承关系，要想使得继承 关系合理，父类和派生类之间必须存在"is-a"关系，即父类和派生类在概念本质上应该是相同的。
对于接口则不 然，并不要求接口的实现者和接口定义在概念本质上是一致的， 仅仅是实现了接口定义的契约而已
*/
//对子类而言，它只能继承一个抽象类(这是 java 为了数据安全而考虑的)，但是却可以实现多个接口
public class Cat implements Annimal, Serializable{
    private static final long serialVersionUID = -4571391638537874894L;

    @Override
    public void eat() {
        System.err.println("eat");
    }

    public static void main(String[] args) {

        new Person("33").test();
        Cat cat = new Cat();
        if (cat instanceof Annimal){
            System.err.println("true");
        }
    }
}
