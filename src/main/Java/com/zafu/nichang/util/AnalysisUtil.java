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
    private DateUtil dateUtil;
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
    public List<Product> analysisProduct(List<Product> productList){
        List<Product> resultAnalysisList = new LinkedList<>();
        List<String> futureDateList = dateUtil.getFutureDateList();

        List<Double> minPriceList = new LinkedList<>();
        List<Double> avgPriceList = new LinkedList<>();
        List<Double> maxPriceList = new LinkedList<>();

        List<Double> futureMinPriceList = new LinkedList<>();
        List<Double> futureAvgPriceList = new LinkedList<>();
        List<Double> futureMaxPriceList = new LinkedList<>();

        for(int i = 0; i < productList.size(); i++){
            minPriceList.add(productList.get(i).getMinPrice());
            avgPriceList.add(productList.get(i).getAvgPrice());
            maxPriceList.add(productList.get(i).getMaxPrice());
        }
        for(int j = 0; j< Constant.FUTURE_WEEK; j++){
            futureMinPriceList.add(getExpect(minPriceList, j, 0.7));
            futureAvgPriceList.add(getExpect(avgPriceList, j, 0.7));
            futureMaxPriceList.add(getExpect(maxPriceList, j, 0.7));
        }

        for(int k = 0; k< Constant.FUTURE_WEEK; k++){
            resultAnalysisList.add(product.setDateTime(futureDateList.get(k)));
            resultAnalysisList.add(product.setMinPrice(futureMinPriceList.get(k)));
            resultAnalysisList.add(product.setAvgPrice(futureAvgPriceList.get(k)));
            resultAnalysisList.add(product.setMaxPrice(futureMaxPriceList.get(k)));
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
        if (list.size() < 10 || modulus <= 0 || modulus >= 1) {
            return null;
        }
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
