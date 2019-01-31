package com.zafu.nichang.service.impl;

import com.zafu.nichang.ApplicationTests;
import com.zafu.nichang.model.Product;
import com.zafu.nichang.model.TransportProduct;
import com.zafu.nichang.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 产品测试类
 * @author 倪畅
 * @date 2019/1/25 10:39
 */
public class ProductServiceImplTest extends ApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void selectProduct() {
        List<Product> productList = productService.selectProduct("FRUIT", "", "", "2019-01-25");
        System.out.println(productList);
    }

    @Test
    @Transactional
    @Rollback
    public void saveProduct() {
        productService.saveProduct(new Product("testName1",1D,2D,3D,"1",
                "1","2018-12-21","12"));
    }

    @Test
    public void selectTransportMessage(){
        List<TransportProduct> transportProductList = productService.selectTransportMessage();
        System.out.println(transportProductList);
    }

    @Test
    public void selectTotalData(){
        List<TransportProduct> transportProductList = productService.selectTotalData();
        System.out.println(transportProductList);
    }
}