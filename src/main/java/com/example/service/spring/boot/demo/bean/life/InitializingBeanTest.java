package com.example.service.spring.boot.demo.bean.life;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by duguangquan on 2018/9/12.
 */
public class InitializingBeanTest implements InitializingBean{

    @Override
    public void afterPropertiesSet() throws Exception {
        System.err.println("afterPropertiesSet");
    }

    /*在基于 XML 的配置元数据的情况下，你可以使用 init-method 属性来指定带有 void 无参数方法的名称*/

    public void init(){
        System.err.println("init InitializingBeanTest");
    }

    public void destroy(){
        System.err.println("destroy InitializingBeanTest");

    }
}
