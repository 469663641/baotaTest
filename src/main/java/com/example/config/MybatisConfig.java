package com.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by baota on 2017/4/7.
 */
@Configuration
@MapperScan("com.example.mapper")
public class MybatisConfig {

}
