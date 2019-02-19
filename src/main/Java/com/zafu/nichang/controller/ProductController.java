package com.zafu.nichang.controller;

import com.zafu.nichang.entity.dto.PageDTO;
import com.zafu.nichang.entity.query.ListQueryCriteria;
import com.zafu.nichang.model.Product;
import com.zafu.nichang.service.ProductService;
import com.zafu.nichang.service.WebSpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 控制器
 * 采用restful的url风格
 *
 * @author 倪畅
 * 2019-01-23
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private WebSpiderService webSpiderService;

    @Autowired
    private ProductService productService;

    @PostMapping("/spider")
    public void insertProduct() {
        webSpiderService.executeSpiderProductFromWeb();
    }

    @PostMapping("/query")
    public PageDTO<List<Product>> selectProduct(@RequestParam("productType") String productType,
                                          @RequestParam("productName") String productName,
                                          @RequestParam("startTime") String startTime,
                                          @RequestParam("endTime") String endTime,
                                          @RequestParam("sizeType") String sizeType){
        return productService.selectProduct(new ListQueryCriteria(productType, productName, startTime, endTime, sizeType));
    }

}
