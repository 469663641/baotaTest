package com.example.service.extend;

import com.example.common.BaseDomain;

/**
 * Created by duguangquan on 2018/8/19.
 */
public class BaseSkinDTO extends BaseDomain{

    private static final long serialVersionUID = -6760350886015681936L;
    private String code;

    private String mame;

    private SkinCapacityModel skinCapacity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMame() {
        return mame;
    }

    public void setMame(String mame) {
        this.mame = mame;
    }

    public SkinCapacityModel getSkinCapacity() {
        return skinCapacity;
    }

    public void setSkinCapacity(SkinCapacityModel skinCapacity) {
        this.skinCapacity = skinCapacity;
    }
}
