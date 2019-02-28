package com.zafu.nichang.mapper;

import com.zafu.nichang.entity.query.ListQueryCriteria;
import com.zafu.nichang.model.MergeEnumProduct;
import com.zafu.nichang.model.Product;
import com.zafu.nichang.model.TransportProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 倪畅
 * 2019-01-23
 */
public interface ProductMapper {

    /**
     * 插入数据接口
     * @param productList
     */
    void insertProduct(List<Product> productList);

    /**
     * 插入一条记录接口
     * @param product
     */
    void saveProduct(Product product);

    /**
     * 分页查询产品接口
     * @param listQueryCriteria
     * @return
     */
    List<Product> selectProduct(ListQueryCriteria listQueryCriteria);

    /**
     * 获得分析商品源数据
     * @param productName
     * @param sizeType
     * @return
     */
    List<Product> getAnalysisProduct(@Param("productName")String productName, @Param("sizeType")String sizeType);

    /**
     * 获取产品的物流信息
     * @return
     */
    List<TransportProduct> selectTransportMessage();

    /**
     * 获取产品的总销量
     * @return
     */
    List<TransportProduct> selectTotalData();

    /**
     * 获得表中每类最大日期
     * @return
     */
    List<Product> getMaxDateFromTable();

    /**
     * 获得表中记录条数
     */
    Integer getSizeFromTable();

    /**
     * detail中的ECharts水果数据接口
     * @return
     */
    List<Product> getGraphFruit();

    /**
     * detail中的ECharts蔬菜数据接口
     * @return
     */
    List<Product> getGraphVegetable();

    /**
     * detail中的ECharts肉类数据接口
     * @return
     */
    List<Product> getGraphMeat();

    /**
     * detail中的ECharts水产数据接口
     * @return
     */
    List<Product> getGraphAquatic();

    /**
     * detail中的ECharts粮油数据接口
     * @return
     */
    List<Product> getGraphOil();

    /**
     * 得到商品枚举值 mybatis实现树形结构接口
     * @return
     */
    List<MergeEnumProduct> getProductEnumTree();

    /**
     * 得到商品枚举值 java实现树形结构接口
     * @return
     */
    List<Product> getProductEnumList();

}
