package com.example.service.extend;

/**
 * Created by duguangquan on 2018/8/19.
 */
//定义DTO 将公共的基类属性抽出来，以后只要在基类加字段后，所有子类的DTO就都有了
public class SkinProblemDTO extends BaseSkinDTO{

    private static final long serialVersionUID = 3853625362195740287L;
    private String level;

    private String location;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
