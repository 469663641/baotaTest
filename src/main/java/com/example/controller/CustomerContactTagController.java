package com.example.controller;

import com.example.service.ivrCall.api.CustomerContactTagService;
import com.example.service.ivrCall.api.dto.CustomerContactTagDTO;
import com.example.service.ivrCall.dao.po.CustomerContactTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by baota on 2017/10/7.
 */
@RestController
@RequestMapping(value = "/tag")
public class CustomerContactTagController {

    @Autowired
    private CustomerContactTagService customerContactTagService;

    @RequestMapping(value = "/getByCustomerContactId", method = RequestMethod.GET)
    public CustomerContactTag getTag(@RequestParam(value = "customerContactId", required = false)
                                             Long customerContactId){

        return customerContactTagService.getTagByCustomerContactId(customerContactId);
    }


    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @Transactional
    public void insertTag(@RequestBody CustomerContactTagDTO customerContactTagDTO){

        customerContactTagService.insertTag(customerContactTagDTO);

    }


}
