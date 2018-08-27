package com.example.service.extend;

/**
 * Created by duguangquan on 2018/8/19.
 */
/*
1.子类拥有父类非 private 的属性和方法
2.对于 protected 而言，它指明就类用户而言，他是 private，但是对于任何继承与此类的子类而言或者其他任何 位于同一个包的类而言，他却是可以访问的
*/
public class Husband extends Person{

    private Integer score;

    //3.对于继承而已，子类会默认调用父类的构造器，但是如果没有默认的父类构造器，子类必须要显 示的指定父类的构造器，而且必须是在子类构造器中做的第一件事(第一行代码)
    public Husband(Integer score) {
        super("hehe");
        this.name = "jj";
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public void test() {
        System.err.println("husband");    }

    public static void main(String[] args) {
        Husband husband = new Husband(30);
        String name = husband.getName();
        Integer score = husband.getScore();
        husband.test();
    }
}
