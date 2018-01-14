package com.example.service.ivrcall.dao.po;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by baota on 2017/10/7.
 */
@Data
@Entity
@Table(name = "gbl_customer_contact_tag")
public class CustomerContactTag  extends BasePO{

    private Long customerContactId;
    private String tag;


}
