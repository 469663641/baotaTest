package com.example.model;

import com.example.common.BaseDomain;

import java.util.List;

/**
 * Created by duguangquan on 2018/8/16.
 */
public class SubjectDTO extends BaseDomain{
    private static final long serialVersionUID = 1168787164954211486L;

    private Long id;

    private List<String> subjectUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getSubjectUrl() {
        return subjectUrl;
    }

    public void setSubjectUrl(List<String> subjectUrl) {
        this.subjectUrl = subjectUrl;
    }
}
