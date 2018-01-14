package com.example.service.ivrcall.core.util;

import com.example.service.ivrcall.api.dto.CustomerContactTagDTO;
import com.example.service.ivrcall.dao.po.CustomerContactTag;
import org.springframework.beans.BeanUtils;

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
