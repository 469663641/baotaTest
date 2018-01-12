package com.example.service.ivrcall.core;

import com.example.service.ivrcall.api.CustomerContactTagService;
import com.example.service.ivrcall.api.dto.CustomerContactTagDTO;
import com.example.service.ivrcall.core.util.Convertor;
import com.example.service.ivrcall.dao.po.CustomerContactTag;
import com.example.service.ivrcall.dao.repository.CustomerContactTagRepository;
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
