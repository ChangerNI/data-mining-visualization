package com.zafu.nichang.controller;

import com.zafu.nichang.service.WebSpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 控制器
 * @author 倪畅
 * 2019-01-23
 */
@Controller
public class ProductController {

    @Autowired
    private WebSpiderService webSpiderService;


    @Autowired
    @RequestMapping("/insertProduct")
    public void insertProduct() {
        webSpiderService.executeSpiderProdctFromWeb();
    }

}
