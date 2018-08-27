package com.example.service.round;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by duguangquan on 2018/8/19.
 */
/*
1、 ROUND_UP:远离零方向舍入。向绝对值最大的方向舍入，只要舍弃位非0即进位。
2、 ROUND_DOWN:趋向零方向舍入。向绝对值最小的方向输入，所有的位都要舍弃，不存在进位情况。
3、 ROUND_CEILING:向正无穷方向舍入。向正最大方向靠拢。若是正数，舍入行为类似于 ROUND_U P，若为负数，舍入行为类似于 ROUND_DOWN。 Math.round() 方法就是使用的此模式。
4、 ROUND_FLOOR:向负无穷方向舍入。向负无穷方向靠拢。若是正数，舍入行为类似于 ROUND_DOW N;若为负数，舍入行为类似于 ROUND_UP。
5、 HALF_UP:最近数字舍入(5进)。这是我们最经典的四舍五入。
6、 HALF_DOWN:最近数字舍入(5舍)。在这里5是要舍弃的。
7、 HAIL_EVEN:银行家舍入法。:[舍去位的数值小于 5 时，直接舍去。 舍去位的数值大于 5 时，进位后舍去。当舍去位的数值等于 5 时，若 5 后面还有其他非 0 数值，则进位后舍去，若 5 后面是 0 时，则根据5前一位数的 奇偶性来判断，奇数进位，偶数舍去。]
*/
public class RoundTest {

    //下面实例是使用银行家舍入法
    public static void main(String[] args) {
        BigDecimal d = new BigDecimal(100000); //存款
        BigDecimal r = new BigDecimal(0.001875*3); //利息
        BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);

        Float ratio = new BigDecimal(2).divide(BigDecimal.valueOf(30),3, BigDecimal.ROUND_HALF_UP)
                .setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();

        // BigDecimal 和四舍五入是绝妙的搭配
        double f = 111231.5585;
        BigDecimal b = new BigDecimal(f);
        double f1 = b.setScale(2, RoundingMode.HALF_UP).doubleValue();

        System.out.println("季利息是:"+i);
    }
}
