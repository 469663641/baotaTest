package com.example.service.aop.demo;

import com.example.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by duguangquan on 2018/9/5.
 */
@Aspect
@Slf4j
@Component
public class LogAspect {

    @Around("@annotation(log)")
    public Object aroundLog(ProceedingJoinPoint joinPoint, Log log) throws Throwable{

        String argNames = log.args();
        String[] argList = StringUtils.split(argNames, ",");

        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String methodDesc = new StringBuilder().append(className).append("#").append(methodName).toString();



        try {
            long startTime = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();

            logInfo(methodDesc, joinPoint, argList, endTime - startTime);

            return result;

        } catch (Exception e) {
            logError(methodDesc, joinPoint, argList, e);
        }

        return null;
    }

    public static void logInfo(String methodDesc, ProceedingJoinPoint joinPoint, String[] argsNames, long rt){

        StringBuilder stringBuilder = new StringBuilder();
        for (String argName : argsNames){
            stringBuilder.append(argName+"={},");
        }
        String argPrefix = stringBuilder.toString();

        if (StringUtils.isNotBlank(argPrefix) && argPrefix.endsWith(",")){
            argPrefix = argPrefix.substring(0, argPrefix.length() - 1);
        }


        Object[] realArgsValue = joinPoint.getArgs();

        String logTemplate = new StringBuilder().append(methodDesc).append("#")
                .append(argPrefix)
                .append(":RT=").append(rt).append("ms")
                .toString();

        log.info(logTemplate, realArgsValue);

    }

    public static void logError(String methodDesc, ProceedingJoinPoint joinPoint, String[] argsNames, Exception e){
        StringBuilder stringBuilder = new StringBuilder();
        for (String argName : argsNames){
            stringBuilder.append(argName+"={},");
        }
        String argPrefix = stringBuilder.toString();

        if (StringUtils.isNotBlank(argPrefix) && argPrefix.endsWith(",")){
            argPrefix = argPrefix.substring(0, argPrefix.length() - 1);
        }

        Object[] realArgsValue = joinPoint.getArgs();

        Object[] objects = new Object[realArgsValue.length + 1];
        int i = 0;
        for (Object object : realArgsValue){
            objects[i] = realArgsValue[1];
            i++;
        }
        objects[i] = e;

        String exceptionStr = "throw exception";

        if (e instanceof BaseException){
            exceptionStr = "throw " + e.getClass().getSimpleName();
        }

        String logErrorTemplate = new StringBuilder().append(methodDesc)
                .append(":").append(exceptionStr)
                .append("#").append(argPrefix).toString();

        log.error(logErrorTemplate, objects);


    }

    public static void main(String[] args) {
        List<String> list = null;

        List<String> list2 = new ArrayList<>();

        list2.addAll(list);
        System.err.println(list2);
    }
}
