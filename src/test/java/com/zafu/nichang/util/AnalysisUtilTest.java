package com.zafu.nichang.util;

import com.zafu.nichang.model.Product;
import com.zafu.nichang.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.zafu.nichang.ApplicationTests;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 数据分析预测测试类
 * @author 倪畅
 * @date 2019/1/29 15:34
 */
public class AnalysisUtilTest extends ApplicationTests {

    @Autowired
    private ProductService productService;

    private AnalysisUtil analysisUtil = new AnalysisUtil();

    @Test
    @Transactional
    public void getAnalysisProduct() {
        List<Product> analysisProductList = productService.getAnalysisProduct("茄子", "普通");
        System.out.println(analysisProductList);

        List<String> resultList = analysisUtil.analysisProduct(analysisProductList);

        System.out.println(resultList);

    }

}