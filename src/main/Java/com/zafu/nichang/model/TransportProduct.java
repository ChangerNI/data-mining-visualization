package com.zafu.nichang.model;

/**
 * @author ：倪畅
 * @date ：Created in 2019/1/31 21:41
 * @description：
 * @modified By：
 * @version: $ 产品流通类
 */
public class TransportProduct {
    private String type;
    private String province;
    private Double percent;
    private Integer totalKG;

    @Override
    public String toString() {
        return "TransportProduct{" +
                "type='" + type + '\'' +
                ", province='" + province + '\'' +
                ", percent=" + percent +
                ", totalKG=" + totalKG +
                '}';
    }

    public Integer getTotalKG() {
        return totalKG;
    }

    public void setTotalKG(Integer totalKG) {
        this.totalKG = totalKG;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }
}
