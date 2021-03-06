package com.example.service.ivrcall.dao.repository;

import com.example.service.ivrcall.dao.po.CustomerContactTag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by baota on 2017/10/7.
 */
public interface CustomerContactTagRepository  extends JpaRepository<CustomerContactTag,Long>{

    CustomerContactTag findByCustomerContactId(Long customerContactId);
}
