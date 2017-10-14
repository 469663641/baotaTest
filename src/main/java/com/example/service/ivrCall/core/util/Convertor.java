package com.example.service.ivrCall.core.util;

import com.example.service.ivrCall.api.dto.CustomerContactTagDTO;
import com.example.service.ivrCall.dao.po.CustomerContactTag;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;

/**
 * Created by baota on 2017/10/7.
 */
public class Convertor {

    public static CustomerContactTag toPO (CustomerContactTagDTO customerContactTagDTO){

        CustomerContactTag customerContactTag =new CustomerContactTag();
        BeanUtils.copyProperties(customerContactTagDTO, customerContactTag);

        return customerContactTag;
    }
}
