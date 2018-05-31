package com.example.service.community;

import com.example.function.Functions;
import com.example.service.user.service.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by duguangquan on 2018/5/31.
 */
@Component
public class skinPlanApplicationHelper {

    public void querySkinPlan(
            List<String> codes,
            Supplier<String> supplier,
            Function<List<String>, UserDTO> skinFunc,
            //Functions参数为返回值
            Functions<List<String>> skinFuncs) {

        String str = supplier.get();
        UserDTO userDTO = skinFunc.apply(codes);

        List<String> stringList = skinFuncs.apply("11", "22");
        System.err.println(stringList);
    }

}
