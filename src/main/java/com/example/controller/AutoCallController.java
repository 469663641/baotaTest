package com.example.controller;

import com.example.service.ivrCall.api.dto.AutoCallDTO;
import com.example.service.ivrCall.dao.po.AutoCall;
import com.example.service.ivrCall.dao.repository.AutoCallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by baota on 2017/10/6.
 */
@RestController
@RequestMapping(value = "/autoCall")
public class AutoCallController {
    @Autowired
    private AutoCallRepository autoCallRepository;

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    public AutoCall getAutoCallById(@PathVariable("id") String id){

        //AutoCall autoCall = autoCallRepository.findOne(id);
        AutoCall autoCall = autoCallRepository.findByBusinessKey(id);
        return autoCall;
    }

    @RequestMapping(value = "/insert/{id}", method = RequestMethod.POST)
    @Transactional//事务注解
    public AutoCall insertAutoCall(@PathVariable("id") Long id,
                               @RequestParam(value = "businessKey",required = false) String busInessKey){
        AutoCall autoCall = new AutoCall();
        autoCall.setId(id);
        autoCall.setBusinessKey(busInessKey);
        autoCall = autoCallRepository.save(autoCall);
        return autoCall;
    }

    @RequestMapping(value = "/insertAnother/{id}",method = RequestMethod.POST)
    public AutoCall insertAutoCall2(@PathVariable(value = "id") Long id,
                                @RequestBody AutoCallDTO autoCallDTO){

        AutoCall autoCall = new AutoCall();
        autoCall.setId(id);
        autoCall.setBusinessKey(autoCallDTO.getBusinessKey());
        autoCall = autoCallRepository.save(autoCall);
        return autoCall;


    }


}
