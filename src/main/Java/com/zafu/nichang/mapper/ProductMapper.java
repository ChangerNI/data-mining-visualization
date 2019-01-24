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


//    List<Product> selectProduct(@Param("userName")String name, @Param("userArea")String area);
}
