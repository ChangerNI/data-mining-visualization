package com.zafu.nichang.util;

import com.zafu.nichang.mapper.ProductMapper;
import com.zafu.nichang.model.Product;

import java.util.List;

/**
 * 数据分析类
 * @author 倪畅
 * @date 2019/1/29 9:31
 */
public class AnalysisUtil {

    private Product product;
    private ProductMapper productMapper;

    /**
     * 得到需要分析的商品数据
     * @param productName
     * @param sizeType
     * @return
     */
    public List<Product> getAnalysisProduct(String productName, String sizeType){
        return productMapper.getAnalysisProduct(productName, sizeType);
    }

    /**
     * 预测未来数据，未来一周
     * @param productList
     * @return
     */
    public List<Product> analysisProduct(List<Product> productList){

//        List<Product> futureProductList
        return productList;
    }
}
