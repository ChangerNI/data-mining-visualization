package com.zafu.nichang;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 单元测试中统一加载类 排除swagger配置文件
 *
 * @author 倪畅
 * @date 2018/11/29 14:43
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {
        "classpath*:/spring-mvc.xml",
        "classpath*:/spring-mybatis.xml"})
@WebAppConfiguration
public class ApplicationTests {


}
