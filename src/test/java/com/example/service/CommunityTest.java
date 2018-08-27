package com.example.service;

import com.example.model.SubjectDTO;
import com.example.model.TipsMixModel;
import com.example.model.TipsModel;
import com.example.service.community.SkinPlanApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by duguangquan on 2018/5/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommunityTest {
    @Autowired
    private SkinPlanApplication skinPlanApplication;

    @Test
    public void queryTest(){

        skinPlanApplication.querySkinPlan();
    }

    @Test
    public void buildTipsModelTest(){
        TipsMixModel<SubjectDTO> tipsMixModel = new TipsMixModel<>();

        TipsModel<List<TipsMixModel>> tipsModel = new TipsModel<>();

        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setSubjectUrl(Arrays.asList("11","22"));
        SubjectDTO subjectDTO2 = new SubjectDTO();
        subjectDTO2.setSubjectUrl(Arrays.asList("33","44"));

        List<SubjectDTO> subjectDTOS = Arrays.asList(subjectDTO, subjectDTO2);

        tipsMixModel.setKey("subjectDTO");
        tipsMixModel.setValues(subjectDTOS);

        tipsModel.setTitle("subjectTitle");
        tipsModel.setContent(Arrays.asList(tipsMixModel));

        System.err.println(tipsModel);

    }

}
