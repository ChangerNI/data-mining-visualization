package com.zafu.nichang.service;

import com.zafu.nichang.model.Product;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author 倪畅
 * 2019-01-23
 */
@Service
@Transactional

public interface ProductService {

    /**
     * 插入数据到数据库
     * @param productList
     */
    List<Product> insertProduct(List<Product> productList);
}