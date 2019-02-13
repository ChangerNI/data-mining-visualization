package com.zafu.nichang.entity.query;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author 倪畅
 * @date 2019/2/13 10:10
 * @description
 */
public class PageInfo {

    /** 当前分页总大小 */
    private Integer pageSize = 10;

    /** 当前页 */
    private Integer pageNum = 1;

    /** 是否需要count */
    private Boolean count = true;

    public PageInfo(Integer pageSize, Integer pageNum, Boolean count) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.count = count;
    }

    public PageInfo() {
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Boolean getCount() {
        return count;
    }

    public void setCount(Boolean count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("pageSize", pageSize)
                .append("pageNum", pageNum)
                .append("count", count)
                .toString();
    }
}
