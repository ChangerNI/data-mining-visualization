package com.zafu.nichang.service.impl;

import com.zafu.nichang.ApplicationTests;
import com.zafu.nichang.entity.dto.PageDTO;
import com.zafu.nichang.entity.query.ListQueryCriteria;
import com.zafu.nichang.model.MergeEnumProduct;
import com.zafu.nichang.model.Product;
import com.zafu.nichang.model.TransportProduct;
import com.zafu.nichang.service.ProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        PageDTO<List<Product>> pageInfo = productService.selectProduct(new ListQueryCriteria("FRUIT",
                                                                                                "",
                                                                                                "",
                                                                                                "",
                                                                                                ""));
        System.out.println(pageInfo.getList());
    }

    @Test
    @Transactional
    @Rollback
    public void saveProduct() {
        productService.saveProduct(new Product(1, "testName1",1D,2D,3D,"1",
                "1","2018-12-21","12"));
    }

    @Test
    public void selectTransportMessage(){
        List<MergeEnumProduct> transportProductList = productService.selectTransportMessage();
        System.out.println(transportProductList);
    }

    @Test
    public void selectTotalData(){
        List<TransportProduct> transportProductList = productService.selectVegetableTotalData();
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

    @Test
    public void getEnumList(){
        List<MergeEnumProduct> mergeEnumProducts = productService.getProductEnumTree();


        System.out.println(mergeEnumProducts);
    }
}