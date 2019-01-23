package com.zafu.nichang.web.mapper;

import com.zafu.nichang.web.service.ProductService;
import com.zafu.nichang.webspider.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author 倪畅
 * 2019-01-23
 */
public interface ProductMapper {

    List<Product> insertProduct(List<Product> productList);
}
