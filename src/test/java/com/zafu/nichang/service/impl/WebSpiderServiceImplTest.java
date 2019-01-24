package com.zafu.nichang.service.impl;

import com.zafu.nichang.ApplicationTests;
import com.zafu.nichang.service.WebSpiderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



public class WebSpiderServiceImplTest extends ApplicationTests {

    @Autowired
    private WebSpiderService webSpiderService;

    @Test
    public void executeSpiderProductFromWeb() {
        webSpiderService.executeSpiderProductFromWeb();
    }
}