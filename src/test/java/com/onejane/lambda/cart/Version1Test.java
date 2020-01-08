package com.onejane.lambda.cart;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 *  第一版查找购物车中数码类商品
 */
public class Version1Test {

    @Test
    public void filterElectronicsSkus() {
        List<Sku> cartSkuList = CartService.getCartSkuList();

        // 查找购物车中数码类商品
        List<Sku> result =
                CartService.filterElectronicsSkus(cartSkuList);

        System.out.println(
                JSON.toJSONString(result, true));
    }

}