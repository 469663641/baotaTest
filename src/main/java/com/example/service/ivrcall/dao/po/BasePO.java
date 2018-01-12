package com.example.service.ivrcall.dao.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by xianglong on 2017/6/20.
 */
@Data
@MappedSuperclass
@EqualsAndHashCode
public class BasePO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected boolean active = true;
    protected String createdBy;
    protected String updatedBy;
    protected Date updatedTime;
    protected Date createdTime;
}
