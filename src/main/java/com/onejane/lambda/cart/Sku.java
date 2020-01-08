package com.onejane.lambda.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 下单商品信息对象
 */
@Data
@Builder // 构造器
@Accessors(chain = true)// 链式编制赋值
@AllArgsConstructor
@NoArgsConstructor
public class Sku {
    // 编号
    private Integer skuId;
    // 商品名称
    private String skuName;
    // 单价
    private Double skuPrice;
    // 购买个数
    private Integer totalNum;
    // 总价
    private Double totalPrice;
    // 商品类型
    private Enum skuCategory;
}
