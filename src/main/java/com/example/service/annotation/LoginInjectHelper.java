package com.example.service.annotation;

import com.example.constant.LoginType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by duguangquan on 2018/8/28.
 */
@Component
public class LoginInjectHelper implements InitializingBean{
    @Autowired
    private ApplicationContext applicationContext;

    private Class getRawClassByAnnotation(Class rawClass, Class<? extends Annotation> annotationClass){

        if (rawClass != null){
            if (rawClass.isAnnotationPresent(annotationClass)) {
                return rawClass;
            }
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        Map<String, Object> controllerBeans = applicationContext.getBeansWithAnnotation(Controller.class);

        if (controllerBeans != null){
            controllerBeans.forEach((key, value) ->{

                Class rawClass = getRawClassByAnnotation(value.getClass(), Controller.class);

                if (rawClass != null){

                    String root = "/";

                    RequestMapping controllerMapping = value.getClass().getAnnotation(RequestMapping.class);

                    if (controllerMapping != null){

                        String[] controllerMappingArr = controllerMapping.value();

                        if (controllerMappingArr != null && controllerMappingArr.length >0){

                            root += controllerMappingArr[0];
                        }
                    }

                    Method[] declaredMethods = rawClass.getDeclaredMethods();
                    if (declaredMethods != null){
                        for (Method method :declaredMethods){

                            if (method.isAnnotationPresent(LoginApiInject.class) && method.isAnnotationPresent(RequestMapping.class)){

                                LoginApiInject loginApiInject = method.getAnnotation(LoginApiInject.class);

                                RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                                String requestMethod = "";
                                RequestMethod[] requestMethodArr = requestMapping.method();
                                if (requestMethodArr != null && requestMethodArr.length >0){
                                    requestMethod = requestMethodArr[0].toString();
                                }
                                String totalUrl="";
                                String[] methodMappingArr = requestMapping.value();
                                if (methodMappingArr != null && methodMappingArr.length >0){
                                   totalUrl = root + methodMappingArr[0];
                                }
                                if (StringUtils.isNotBlank(totalUrl) && StringUtils.isNotBlank(requestMethod)){
                                    totalUrl = totalUrl.replaceAll("//","/");
                                    String loginInfoInject = totalUrl +"#"+requestMethod;
                                    LoginType type = loginApiInject.type();
                                    System.err.println(type);
                                }
                            }
                        }
                    }
                }
            });


        }

    }
}
