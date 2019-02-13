package com.zafu.nichang.service.impl;

import com.github.pagehelper.PageInfo;
import com.zafu.nichang.ApplicationTests;
import com.zafu.nichang.entity.dto.PageDTO;
import com.zafu.nichang.entity.query.ListQueryCriteria;
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
        PageDTO<List<Product>> pageInfo = productService.selectProduct(new ListQueryCriteria("",
                                                                                                "国产平鱼",
                                                                                                "2019-01-11",
                                                                                                "2019-02-12",
                                                                                                "带头"));
        System.out.println(pageInfo.getList());
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

    @Test
    public void getMaxDate(){
        List<Product> stringList = productService.getMaxDateFromTable();
        System.out.println(stringList);
    }

    @Test
    public void getSizeFromTable(){
        Integer number = productService.getSizeFromTable();
        System.out.println(number);
    }
}