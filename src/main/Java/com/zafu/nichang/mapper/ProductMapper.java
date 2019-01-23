package com.zafu.nichang.mapper;

import com.zafu.nichang.model.Product;

import java.util.List;

/**
 * @author 倪畅
 * 2019-01-23
 */
public interface ProductMapper {

    /**
     * 插入数据接口
     * @param productList
     */
    void insertProduct(List<Product> productList);
}
