package com.example.service.ivrCall.api.dto;

import com.example.service.ivrCall.dao.po.BasePO;
import lombok.Data;

/**
 * Created by baota on 2017/10/7.
 */
@Data
public class CustomerContactTagDTO extends BasePO {

    private Long customerContactId;
    private String tag;

}
