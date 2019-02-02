package com.zafu.nichang.model;

/**
 * @author ：倪畅
 * @date ：Created in 2019/2/2 19:03
 * @description：未来七天产品类
 * @modified By：
 * @version: 1.0$
 */
public class AnalysisProduct {
    private String dateTime;
    private Double minPrice;
    private Double avgPrice;
    private Double maxPrice;

    @Override
    public String toString() {
        return "AnalysisProduct{" +
                "dateTime='" + dateTime + '\'' +
                ", minPrice=" + minPrice +
                ", avgPrice=" + avgPrice +
                ", maxPrice=" + maxPrice +
                '}';
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }
}
