package com.zafu.nichang.service;

import com.zafu.nichang.model.Product;

import java.util.List;

/**
 * 产品service接口
 * @author 倪畅
 * 2019-01-23
 */
public interface ProductService {

    /**
     * 插入数据到数据库
     * @param productList
     */
    void insertProduct(List<Product> productList);


    /**
     * 获得产品信息
     * @param productName
     * @param startTime
     * @param endTime
     * @return
     */
    List<Product> selectProduct(String productName, String startTime, String endTime);
}