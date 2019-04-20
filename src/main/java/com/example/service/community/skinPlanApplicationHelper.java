package com.example.service.community;

import com.example.function.Functions;
import com.example.service.user.service.UserDTO;
import com.google.common.collect.Lists;
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


    /**
     * 根据缓存查询数据
     *
     * @param dataSupplier 数据查询接口
     * @param expireTime 缓存过期时间
     * @param keySupplier 缓存Key
     * @param <T> 查询数据类型
     * @return
     */
    public <T> T queryWithCache(Supplier<T> dataSupplier,
                                int expireTime,
                                Supplier<String> keySupplier) {

        String key = keySupplier.get();
       /* MemcacheResult<T, String> memcacheResult = memcacheHelper.get(key);
        if (!memcacheResult.isNil()) {
            T data = memcacheResult.getIncludeData();
            // 判断是否为空对象
            if (Null.isNull(data)) {
                return null;
            }
            return data;
        }

        T dbData = dataSupplier.get();
        McCache mcCache = new McCache();
        mcCache.setKey(key);
        mcCache.setData(isNullObject(dbData) ? Null.INSTANCE : dbData);
        mcCache.setExpireTime(isNullObject(dbData) ? nullExpireTime() : expireTime);
        putToMc(Lists.newArrayList(mcCache));
        return dbData;*/
       return null;
    }

}
