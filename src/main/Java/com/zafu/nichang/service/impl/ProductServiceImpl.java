package com.zafu.nichang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zafu.nichang.entity.dto.PageDTO;
import com.zafu.nichang.entity.query.ListQueryCriteria;
import com.zafu.nichang.mapper.ProductMapper;
import com.zafu.nichang.model.MergeEnumProduct;
import com.zafu.nichang.model.Product;
import com.zafu.nichang.model.TransportProduct;
import com.zafu.nichang.service.MessageService;
import com.zafu.nichang.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
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
     * @return
     */
    @Override
    public List<MergeEnumProduct> getProductEnumTree() {
        return productMapper.getProductEnumTree();
    }

    @Override
    public List<MergeEnumProduct> getProductEnumList() {
        List<Product> productList = productMapper.getProductEnumList();
        List<MergeEnumProduct> mergeEnumProductList = new LinkedList<>();

        for (int i = 0; i < productList.size(); i++) {
            List<MergeEnumProduct> productNameList = new LinkedList<>();
            List<MergeEnumProduct> productSizeList = new LinkedList<>();

            productSizeList.add(new MergeEnumProduct("product_size",
                    productList.get(i).getSizeType(),
                    null));
            productNameList.add(new MergeEnumProduct("product_name",
                    productList.get(i).getProductName(),
                    productSizeList));
            if (mergeEnumProductList.size() == 0){
                mergeEnumProductList.add(new MergeEnumProduct("product_type",
                        productList.get(i).getProductType(),
                        productNameList));
            }
            for (int j = 0; j < mergeEnumProductList.size(); j++) {
                if(mergeEnumProductList.get(j).getValue().equals(productList.get(i).getProductType())){

                    mergeEnumProductList.get(j).setChildren(productNameList);
                }else{
                    mergeEnumProductList.add(new MergeEnumProduct("product_type",
                            productList.get(i).getProductType(),
                            productNameList));
                }
            }
        }

        return mergeEnumProductList;
    }

}