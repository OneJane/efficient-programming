package com.onejane.lambda.stream;

import com.alibaba.fastjson.JSON;
import com.onejane.lambda.cart.CartService;
import com.onejane.lambda.cart.Sku;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ Author : Weijian_Wang
 * @ Date : Created in 9:45 2019/10/15 0015
 * @ Description ：常见预定义收集器使用
 */
public class StreamCollector {

    /**
     * 集合收集器
     */
    @Test
    public void toList() {
        List<Sku> list = CartService.getCartSkuList();

        List<Sku> result = list.stream()
                .filter(sku -> sku.getTotalPrice() > 100)
                .collect(Collectors.toList());

        System.out.println(JSON.toJSONString(result, true));

        List<Sku> s = result.stream().map(vo -> {
            Sku sku = Sku.builder().skuId(1).skuName(vo.getSkuName()).build();
            return sku;
        }).collect(Collectors.toList());
    }

    /**
     * 分组
     */
    @Test
    public void group() {
        List<Sku> list = CartService.getCartSkuList();

        //Map<分组条件，结果集合>
        Map<Object,List<Sku>> group = list.stream()
                //groupingBy入参为Function<T, R>
                .collect(Collectors.groupingBy(sku -> sku.getSkuCategory()));
        System.out.println(JSON.toJSONString(group, true));
    }

    @Test
    public void partition() {
        List<Sku> list = CartService.getCartSkuList();

        Map<Boolean, List<Sku>> partition = list.stream()
                .collect(Collectors.partitioningBy(sku -> sku.getTotalPrice() > 100));

        System.out.println(JSON.toJSONString(partition, true));
    }
}
