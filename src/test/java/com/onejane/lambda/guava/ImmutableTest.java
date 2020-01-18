package com.onejane.lambda.guava;


import com.google.common.collect.ImmutableSet;
import org.assertj.core.util.Sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 23:09 2019/10/16 0016
 * @ Description ：不可变集合用法
 * 当对象不可信的库调用时，不可变形式是安全的
 * 不可变对象被多个线程调用时，不存在惊态条件问题
 * 不可变集合不需要考虑变化，可以节省时间和空间
 * 不可变对象因为固定不变，可以作为常量来安全使用
 */
public class ImmutableTest {

    public static void test(List<Integer> list) {
        list.remove(0);
    }

    public void immutable() {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        /**
         * 构造不可变集合对象三种方式
         */
        //通过已存在的集合创建
        ImmutableSet immutableSet = ImmutableSet.copyOf(list);

        //通过初始值，直接创建不可变集合
        ImmutableSet immutableSet1 = ImmutableSet.of(1, 2, 3);

        //以builder方式创建
        ImmutableSet.builder()
                .add(1)
                .addAll(Sets.newTreeSet(2, 3))
                .add(4)
                .build();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> newList = Collections.unmodifiableList(list); // 将可变list变成不可变集合

        test(newList);

        System.out.println(newList);
    }
}
