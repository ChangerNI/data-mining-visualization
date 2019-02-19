package com.zafu.nichang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zafu.nichang.entity.dto.PageDTO;
import com.zafu.nichang.entity.query.ListQueryCriteria;
import com.zafu.nichang.mapper.ProductMapper;
import com.zafu.nichang.model.Product;
import com.zafu.nichang.model.TransportProduct;
import com.zafu.nichang.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据处理入口
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

    /**
     * 新增一条数据
     * @param product
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveProduct(Product product) {
        productMapper.saveProduct(product);
    }

    /**
     * 分页查询产品
     * @return
     */
    @Override
    public PageDTO<List<Product>> selectProduct(ListQueryCriteria listQueryCriteria) {

        PageInfo<List<Product>> pageInfo = PageHelper.startPage(listQueryCriteria.getPageNum(), listQueryCriteria.getPageSize())
                .doSelectPageInfo(() -> productMapper.selectProduct(listQueryCriteria));


        return new PageDTO<>(pageInfo.getList(), pageInfo.getTotal(), listQueryCriteria.getPageNum());
    }

    /**
     * 获得分析商品源数据
     * @param productName
     * @param sizeType
     * @return
     */
    @Override
    public List<Product> getAnalysisProduct(String productName, String sizeType) {
        return productMapper.getAnalysisProduct(productName, sizeType);
    }

    /**
     * 查询产品流通信息
     * @return
     */
    @Override
    public List<TransportProduct> selectTransportMessage() {
        return productMapper.selectTransportMessage();
    }

    /**
     * 查询产品总销量
     * @return
     */
    @Override
    public List<TransportProduct> selectTotalData() {
        return productMapper.selectTotalData();
    }

    /**
     * 获得表中每个类别的最大日期
     * @return
     */
    @Override
    public List<Product> getMaxDateFromTable() {
        return productMapper.getMaxDateFromTable();
    }

    /**
     * 获得表中记录条数
     */
    @Override
    public Integer getSizeFromTable() {
        return productMapper.getSizeFromTable();
    }
}