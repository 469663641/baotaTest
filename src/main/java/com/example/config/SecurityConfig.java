package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by baota on 2018/2/4.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    //要注释掉，不然要验证权限才能访问controller
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        /*http.authorizeRequests()
                .antMatchers("/","/index","*//*").permitAll()//index不用验证
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .logout()
                .permitAll();*/


    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{


        /*auth.inMemoryAuthentication()
                .withUser("demo").password("demo").roles("USER")//demo用户
                .and()
                .withUser("admin").password("admin").roles("ADMIN");//admin用户
*/
    }


}
