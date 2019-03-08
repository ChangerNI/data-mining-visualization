package com.zafu.nichang.service;

import com.zafu.nichang.ApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 倪畅
 * @date 2019/3/8 10:39
 */
public class ProductServiceTest extends ApplicationTests {

    @Autowired
    private ProductService productService;
    @Test
    public void getTree(){
        System.out.println(productService.getProductEnumList());
    }
}