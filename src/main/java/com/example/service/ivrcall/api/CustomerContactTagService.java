package com.example.service.ivrcall.api;

import com.example.service.ivrcall.api.dto.CustomerContactTagDTO;
import com.example.service.ivrcall.dao.po.CustomerContactTag;

/**
 * Created by baota on 2017/10/7.
 */
public interface CustomerContactTagService {

    CustomerContactTag getTagByCustomerContactId(Long customerContactId);

    void insertTag(CustomerContactTagDTO customerContactTagDTO);
}
