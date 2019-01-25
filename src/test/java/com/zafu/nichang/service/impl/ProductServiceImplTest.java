package com.zafu.nichang.service.impl;

import com.zafu.nichang.ApplicationTests;
import com.zafu.nichang.model.Product;
import com.zafu.nichang.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
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
}