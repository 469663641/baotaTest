package com.example.service.ivrCall.api;

import com.example.service.ivrCall.api.dto.CustomerContactTagDTO;
import com.example.service.ivrCall.dao.po.CustomerContactTag;

/**
 * Created by baota on 2017/10/7.
 */
public interface CustomerContactTagService {

    CustomerContactTag getTagByCustomerContactId(Long customerContactId);

    void insertTag(CustomerContactTagDTO customerContactTagDTO);
}
