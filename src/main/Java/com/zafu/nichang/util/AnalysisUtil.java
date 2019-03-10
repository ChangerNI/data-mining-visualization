package com.zafu.nichang.util;

import com.zafu.nichang.mapper.ProductMapper;
import com.zafu.nichang.model.Constant;
import com.zafu.nichang.model.Product;

import java.util.LinkedList;
import java.util.List;

/**
 * 数据分析类
 * @author 倪畅
 * @date 2019/1/29 9:31
 */
public class AnalysisUtil {

    private Product product;
    private DateUtil dateUtil = new DateUtil();
    private ProductMapper productMapper;

    /**
     * 得到需要分析的商品数据
     * @param productName
     * @param sizeType
     * @return
     */
    public List<Product> getAnalysisProduct(String productName, String sizeType){
        return productMapper.getAnalysisProduct(productName, sizeType);
    }

    /**
     * 预测未来数据，未来一周
     * @param productList
     * @return
     */
    public List<String> analysisProduct(List<Product> productList){
        List<String> resultAnalysisList = new LinkedList<>();
        List<String> futureDateList = dateUtil.getFutureDateList();

        List<Double> minPriceList = new LinkedList<>();
        List<Double> avgPriceList = new LinkedList<>();
        List<Double> maxPriceList = new LinkedList<>();

        List<Double> futureMinPriceList = new LinkedList<>();
        List<Double> futureAvgPriceList = new LinkedList<>();
        List<Double> futureMaxPriceList = new LinkedList<>();

        for (Product product1 : productList) {
            minPriceList.add(product1.getMinPrice());
            avgPriceList.add(product1.getAvgPrice());
            maxPriceList.add(product1.getMaxPrice());
        }
        for(int j = 0; j< Constant.FUTURE_WEEK; j++){
            Double random = Math.random();
            futureMinPriceList.add(getExpect(minPriceList, j, random));
            futureAvgPriceList.add(getExpect(avgPriceList, j, random));
            futureMaxPriceList.add(getExpect(maxPriceList, j, random));
        }

        for(int k = 0; k< Constant.FUTURE_WEEK; k++){
            resultAnalysisList.add(futureDateList.get(k));
            resultAnalysisList.add(String.valueOf(futureMinPriceList.get(k)));
            resultAnalysisList.add(String.valueOf(futureAvgPriceList.get(k)));
            resultAnalysisList.add(String.valueOf(futureMaxPriceList.get(k)));
        }
        return resultAnalysisList;
    }
    /**
     * 二次指数平滑法求预测值
     * @param list 基础数据集合
     * @param modulus 平滑系数
     * @return 预测值
     */
    private static Double getExpect(List<Double> list, int day, Double modulus ) {
        Double modulusLeft = 1 - modulus;
        Double lastIndex = list.get(0);
        Double lastSecIndex = list.get(0);
        for (Double data : list) {
            lastIndex = modulus * data + modulusLeft * lastIndex;
            lastSecIndex = modulus * lastIndex + modulusLeft * lastSecIndex;
        }
        Double a = 2 * lastIndex - lastSecIndex;
        Double b = (modulus / modulusLeft) * (lastIndex - lastSecIndex);
        return a + b * day;
    }
}
