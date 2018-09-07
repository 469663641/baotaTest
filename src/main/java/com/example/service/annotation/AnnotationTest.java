package com.example.service.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by duguangquan on 2018/8/12.
 */
public class AnnotationTest {

    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setName("baota");

        String query = query(customer);
        System.err.println(query);

    }
    
    private static String query(Object customer){
        
        //类名反射获取类
        //Class.forName("com.example.service.annotation.Customer");

        //获取类
        Class c = customer.getClass();

        boolean classPresent = c.isAnnotationPresent(Table.class);
        if (!classPresent){
            return null;
        }
        Table t = (Table) c.getAnnotation(Table.class);
        String tableName = t.value();

        StringBuilder sb = new StringBuilder();
        sb.append("select * from ").append(tableName).append(" where 1=1 and ");


        //获取所有方法
        Method[] methods = c.getMethods();
        Method[] declaredMethods = c.getDeclaredMethods();
        //获取所有字段
        Field[] declaredFields = c.getDeclaredFields();
        
        for (Field field : declaredFields){

            boolean filedPresent = field.isAnnotationPresent(Column.class);
            if (!filedPresent) {
                continue;
            }

            Column column = field.getAnnotation(Column.class);
            //
            String columnName = column.value();
            //字段的名称
            String fieldName = field.getName();
            //通过该字段方法名的反射，获取该字段的值,拼接getMethodName
            String getMethodName = "get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);

            Object filedValue = null;
            try {
                Method method = c.getMethod(getMethodName);
                filedValue =  method.invoke(customer);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (filedValue == null) {
                continue;
            }
            if (filedValue instanceof Integer && filedValue.equals(0)){
                continue;
            }

            sb.append(columnName).append("='").append(filedValue).append("'");

        }


        return sb.toString();
    }


}
