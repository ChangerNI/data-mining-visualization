package com.zafu.nichang.service.impl;

import com.zafu.nichang.ApplicationTests;
import com.zafu.nichang.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author 朱文赵
 * @date 2019/1/25 10:39
 */
public class ProductServiceImplTest extends ApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void selectProduct() {
        productService.selectProduct("test", "test", "test");

    }
}