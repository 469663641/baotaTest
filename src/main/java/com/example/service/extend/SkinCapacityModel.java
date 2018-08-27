package com.example.service.extend;

import com.example.common.BaseDomain;

/**
 * Created by duguangquan on 2018/8/19.
 */
public class SkinCapacityModel extends BaseDomain{
    private static final long serialVersionUID = -4440905403556641676L;

    private String capacityCode;

    private String capacityLevel;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCapacityCode() {
        return capacityCode;
    }

    public void setCapacityCode(String capacityCode) {
        this.capacityCode = capacityCode;
    }

    public String getCapacityLevel() {
        return capacityLevel;
    }

    public void setCapacityLevel(String capacityLevel) {
        this.capacityLevel = capacityLevel;
    }
}
