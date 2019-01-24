package com.zafu.nichang.service;

import com.zafu.nichang.model.Product;

import java.util.List;

/**
 *
 * @author 倪畅
 * 2019-01-23
 */
public interface ProductService {

    /**
     * 插入数据到数据库
     * @param productList
     */
    void insertProduct(List<Product> productList);
}