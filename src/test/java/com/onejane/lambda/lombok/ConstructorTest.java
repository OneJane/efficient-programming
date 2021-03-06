package com.onejane.lambda.lombok;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 15:27 2019/10/19 0019
 * @ Description ：
 * @AllArgsConstructor
 * @NoArgsConstructor
 * @RequiredArgsConstructor
 */

//@AllArgsConstructor
//@NoArgsConstructor
    @RequiredArgsConstructor // field1 field2
public class ConstructorTest {

    private final String field1;

    @NonNull
    private String field2;

    private String field3;
}
