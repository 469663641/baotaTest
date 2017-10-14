package com.example.service.ivrCall.core;

import com.example.service.ivrCall.api.CustomerContactTagService;
import com.example.service.ivrCall.api.dto.CustomerContactTagDTO;
import com.example.service.ivrCall.core.util.Convertor;
import com.example.service.ivrCall.dao.po.CustomerContactTag;
import com.example.service.ivrCall.dao.repository.CustomerContactTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by baota on 2017/10/7.
 */

@Service
public class DefaultCustomerContactTagService implements CustomerContactTagService {
    @Autowired
    private CustomerContactTagRepository customerContactTagRepository;

    @Override
    public CustomerContactTag getTagByCustomerContactId(Long customerContactId){
        return customerContactTagRepository.findByCustomerContactId(customerContactId);
    }

    @Override
    public void insertTag(CustomerContactTagDTO customerContactTagDTO){

        if (customerContactTagDTO ==null) {
            return;
        }

        customerContactTagRepository.save(Convertor.toPO(customerContactTagDTO));


    }

}
