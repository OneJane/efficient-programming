package com.onejane.lambda.lombok;

import lombok.NonNull;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 15:23 2019/10/19 0019
 * @ Description ：@NonNull注解，生成非空检查
 */
public class NonNullTest {

    // 优先判断是否为空
    public NonNullTest(@NonNull String field){
        System.out.println(field);
    }
}
