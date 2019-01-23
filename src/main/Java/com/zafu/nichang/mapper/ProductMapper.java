package com.zafu.nichang.mapper;

import com.zafu.nichang.model.Product;

import java.util.List;

/**
 * @author 倪畅
 * 2019-01-23
 */
public interface ProductMapper {

    List<Product> insertProduct(List<Product> productList);
}
