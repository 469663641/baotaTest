package com.example.service.ivrCall.dao.repository;


import com.example.service.ivrCall.dao.po.AutoCall;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by baota on 2017/7/26.
 */
public interface AutoCallRepository extends JpaRepository<AutoCall, Long> {

    List<AutoCall> findByRecordStatusNotAndCreatedTimeAfter(int recordStatus, Date beforeCreatedDay);

    AutoCall findByBusinessKey(String businessKey);

    List<AutoCall> findByCaseIdAndRecordStatusAndCreatedTimeBetween(Long caseId, int recordStatus,
                                                                    Date dateBefore, Date dateAfter);
    List<AutoCall> findByBusinessKeyIn(List<String> businessKeyList);


}
