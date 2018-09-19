package com.example.service.spring.boot.demo.config;

import com.example.config.JavaConfig;
import com.example.service.spring.boot.demo.beanExtends.HelloWorld;
import com.example.service.spring.boot.demo.beanExtends.SubHelloWorld;
import com.example.service.test.Hello;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by baota on 2018/4/5.
 */

public class applicationContextTest implements ApplicationContextAware {

    //获取application上下文
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }

    public static void main(String[] args) {


        //这个不行，要加载整个项目才行，详细见 StrategyTest
        //Hello bean1 = applicationContext.getBean(Hello.class);
        //bean1.sayHello();

        //获取上下文ClassPathXmlApplicationContext
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld bean1 = classPathXmlApplicationContext.getBean(HelloWorld.class);
        SubHelloWorld bean2 = classPathXmlApplicationContext.getBean(SubHelloWorld.class);
        bean1.getMessage1();
        bean2.getMessage3();
        System.err.println(bean2);

        Hello bean = classPathXmlApplicationContext.getBean(Hello.class);
        bean.sayHello();


        //获取上下文AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext context =
                //new AnnotationConfigApplicationContext(DiConfig.class);
                new AnnotationConfigApplicationContext(JavaConfig.class);
        //UseFunctionService useFunctionService = context.getBean(UseFunctionService.class);
        //String str = useFunctionService.sayHello();
        FunctionService functionService = context.getBean(FunctionService.class);
        String str = functionService.sayHello();
        System.err.println(str);
    }


}
