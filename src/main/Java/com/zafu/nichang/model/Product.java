package com.zafu.nichang.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

/**
 * 产品类
 * 使用lombok重构
 * @author 倪畅
 * @version 1.0 2019-01-18
 * @version 2.0 2019-02-18
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class  Product {

    private String productName;
    private Double minPrice;
    private Double avgPrice;
    private Double maxPrice;
    private String sizeType;
    private String unit;
    private String dateTime;
    private String productType;

    public Product(LinkedList<String> productNameLists,
                   LinkedList<String> productDetailsLists,
                   String productType) {
        this.productName = productNameLists.removeFirst();
        this.minPrice = Double.valueOf(productDetailsLists.removeFirst());
        this.avgPrice = Double.valueOf(productDetailsLists.removeFirst());
        this.maxPrice = Double.valueOf(productDetailsLists.removeFirst());
        this.sizeType = productDetailsLists.removeFirst();
        this.unit = productDetailsLists.removeFirst();
        this.dateTime = productDetailsLists.removeFirst();
        this.productType = productType;
    }
}
