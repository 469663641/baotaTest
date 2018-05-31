package com.example.service.community;

import com.example.model.User;
import com.example.service.user.service.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by duguangquan on 2018/5/31.
 */
@Component
public class SkinPlanApplicationImpl implements SkinPlanApplication {

    @Autowired
    private skinPlanApplicationHelper helper;

    @Override
    public void querySkinPlan() {

        List<String> codes = Arrays.asList("12", "33", "8");

        helper.querySkinPlan(
                codes,
                () -> fetchString(),
                (codeList) -> fetchUserDTOByCode(codeList, false),
                //只是形参，在helper中传
                (params) -> fetchList((String) params[0], (String) params[1])
        );
    }

    private String fetchString() {

        return "string";
    }

    private UserDTO fetchUserDTOByCode(List<String> codes, boolean isTurnOn) {

        if (isTurnOn) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        return userDTO;
    }

    private List<String> fetchList(String str1, String str2) {

        List<String> codes = Arrays.asList("12", "33", "8");
        return codes;
    }


}
