package com.zafu.nichang.entity.query;

/**
 * @author 倪畅
 * @date 2019/2/13 16:17
 */
public class ListQueryCriteria extends PageInfo{

    private String productType;
    private String productName;
    private String startTime;
    private String endTime;
    private String sizeType;

    public ListQueryCriteria() {
    }

    public ListQueryCriteria(String productType, String productName, String startTime, String endTime, String sizeType) {
        this.productType = productType;
        this.productName = productName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.sizeType = sizeType;
    }

    public String getSizeType() {
        return sizeType;
    }

    public void setSizeType(String sizeType) {
        this.sizeType = sizeType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
