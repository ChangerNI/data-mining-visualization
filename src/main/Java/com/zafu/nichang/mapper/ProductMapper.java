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
     * 插入一条记录接口
     * @param product
     */
    void saveProduct(Product product);

    /**
     * 获取数据接口
     * @param startTime
     * @param endTime
     * @return
     */
    List<Product> selectProduct(@Param("productType")String productType, @Param("productName")String productName,
                                @Param("startDT")String startTime, @Param("endDT")String endTime);

    /**
     * 获得分析商品源数据
     * @param productName
     * @param sizeType
     * @return
     */
    List<Product> getAnalysisProduct(@Param("productName")String productName, @Param("sizeType")String sizeType);


    /**
     * 获取农产品的物流信息
     * @return
     */
    List<Product> selectTransportMessage();

    /**
     * 获取农产品的总销量
     * @return
     */
    List<Product> selectTotalData();
}
