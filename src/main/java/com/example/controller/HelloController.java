package com.example.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by baota on 2017/10/5.
 */

@RestController
@RequestMapping(value = "/node")
public class HelloController {
    @RequestMapping(value = {"/hello/{id}","/hi"}, method = RequestMethod.GET)
    public String getHello(@PathVariable("id") Integer id){

        return "hello world"+id;
    }

    @RequestMapping(value = "/kk",method = RequestMethod.GET)
    public String gethah(@RequestParam(value = "id",required = false,defaultValue = "00") Integer id){

        return "jjjj:"+id;

    }
}
