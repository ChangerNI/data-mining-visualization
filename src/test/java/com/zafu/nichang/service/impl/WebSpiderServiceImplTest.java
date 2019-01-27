package com.zafu.nichang.service.impl;

import com.zafu.nichang.ApplicationTests;
import com.zafu.nichang.service.WebSpiderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


public class WebSpiderServiceImplTest extends ApplicationTests {

    @Autowired
    private WebSpiderService webSpiderService;

    @Test
    @Transactional
    @Rollback()
    public void executeSpiderProductFromWeb() {
        webSpiderService.executeSpiderProductFromWeb();
    }
}