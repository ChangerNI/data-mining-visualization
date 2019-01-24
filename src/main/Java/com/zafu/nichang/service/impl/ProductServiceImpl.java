package com.zafu.nichang.service.impl;

import com.zafu.nichang.mapper.ProductMapper;
import com.zafu.nichang.model.Product;
import com.zafu.nichang.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 倪畅
 * 2019-01-23
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    /**
     * 新增数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertProduct(List<Product> productList) {
        productMapper.insertProduct(productList);
    }

}