package com.zafu.nichang.mapper;

import com.zafu.nichang.model.Product;
import org.apache.ibatis.annotations.Param;

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


    /**
     * 获取数据接口
     * @param startTime
     * @param endTime
     * @return
     */
    List<Product> selectProduct(@Param("productType")String productType, @Param("productName")String productName, @Param("startDT")String startTime, @Param("endDT")String endTime);
}
