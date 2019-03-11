package com.zafu.nichang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zafu.nichang.constants.ProductConstants;
import com.zafu.nichang.entity.dto.PageDTO;
import com.zafu.nichang.entity.query.ListQueryCriteria;
import com.zafu.nichang.mapper.ProductMapper;
import com.zafu.nichang.model.MergeEnumProduct;
import com.zafu.nichang.model.Product;
import com.zafu.nichang.model.TransportProduct;
import com.zafu.nichang.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 数据处理入口
 *
 * @author 倪畅
 * 2019-01-23
 */
@Service
@Slf4j
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
     *
     * @param product
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveProduct(Product product) {
        productMapper.saveProduct(product);
    }

    /**
     * 分页查询产品
     *
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
     *
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
     *
     * @return
     */
    @Override
    public List<MergeEnumProduct> selectTransportMessage() {
        return productMapper.selectTransportMessage();
    }

    @Override
    public List<TransportProduct> selectVegetableTotalData() {
        return productMapper.selectVegetableTotalData();
    }

    @Override
    public List<TransportProduct> selectFruitTotalData() {
        return productMapper.selectFruitTotalData();
    }

    @Override
    public List<TransportProduct> selectMeatTotalData() {
        return productMapper.selectMeatTotalData();
    }

    @Override
    public List<TransportProduct> selectAquaticTotalData() {
        return productMapper.selectAquaticTotalData();
    }

    @Override
    public List<TransportProduct> selectOilTotalData() {
        return productMapper.selectOilTotalData();
    }

    /**
     * 获得表中每个类别的最大日期
     *
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

    /**
     * detail中的ECharts数据接口
     *
     * @return
     */
    @Override
    public List<Product> getGraphFruit() {
        return productMapper.getGraphFruit();
    }

    @Override
    public List<Product> getGraphVegetable() {
        return productMapper.getGraphVegetable();
    }

    @Override
    public List<Product> getGraphMeat() {
        return productMapper.getGraphMeat();
    }

    @Override
    public List<Product> getGraphAquatic() {
        return productMapper.getGraphAquatic();
    }

    @Override
    public List<Product> getGraphOil() {
        return productMapper.getGraphOil();
    }

    /**
     * 得到产品枚举值
     *
     * @return
     */
    @Override
    public List<MergeEnumProduct> getProductEnumTree() {
        return productMapper.getProductEnumTree();
    }

    @Override
    public List<MergeEnumProduct> getProductEnumList() {
        List<MergeEnumProduct> mergeEnumProductList = new LinkedList<>();
        Map<String, Map<String, List<Product>>> enumKeyValue = getEnumKeyValue(productMapper.getProductEnumList());

        enumKeyValue.forEach((typeKey, typeValue) -> {
            // 添加产品类型
            MergeEnumProduct productType = new MergeEnumProduct(ProductConstants.PRODUCT_TYPE, typeKey);
            mergeEnumProductList.add(productType);
            typeValue.forEach((nameKey, nameValue) -> {
                // 添加产品名称
                MergeEnumProduct productName = new MergeEnumProduct(ProductConstants.PRODUCT_NAME, nameKey);
                productType.addChild(productName);

                // 添加名称下的size类型
                List<MergeEnumProduct> sizeTypeList = nameValue.stream().map(Product::getSizeType)
                        .map(sizeType -> new MergeEnumProduct(ProductConstants.SIZE_TYPE, sizeType))
                        .collect(Collectors.toCollection(LinkedList::new));
                productName.setChildren(sizeTypeList);
            });
        });

        return mergeEnumProductList;
    }

    private Map<String, Map<String, List<Product>>> getEnumKeyValue(List<Product> productList) {
        return productList.parallelStream().collect(Collectors.groupingBy(Product::getProductType,
                Collectors.groupingBy(Product::getProductName)));
    }
}