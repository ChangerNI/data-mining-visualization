package com.zafu.nichang.controller;

import com.zafu.nichang.service.WebSpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


    @PostMapping("/spider")
    public void insertProduct() {
        webSpiderService.executeSpiderProductFromWeb();
    }

}
