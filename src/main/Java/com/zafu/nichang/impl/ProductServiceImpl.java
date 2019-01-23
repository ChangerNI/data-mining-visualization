package com.zafu.nichang.impl;

import com.zafu.nichang.mapper.ProductMapper;
import com.zafu.nichang.service.ProductService;
import com.zafu.nichang.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 倪畅
 * 2019-01-23
 */
@Service
/* 此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。*/
@Transactional

public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;
    /**
     * 新增数据
     */
    @Override
    public List<Product> insertProduct(List<Product> productList) {
        return productMapper.insertProduct(productList);
    }

}