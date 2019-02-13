package com.zafu.nichang.entity.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 倪畅
 * @date 2019/2/13 15:58
 * @description 为了在分页的时将 实体类转化为DTO能够正常传输
 */
public class PageDTO<T> implements Serializable {

    private static final long serialVersionUID = 3963397825286103250L;

    /** 总的列表*/
    private List<T> list;
    /** 总条数*/
    private Long total;
    /** 当前页*/
    private Integer pageNum;

    public PageDTO() {
    }

    public PageDTO(List<T> list, Long total) {
        this.list = list;
        this.total = total;
    }

    public PageDTO(List<T> list, Long total, Integer pageNum) {
        this.list = list;
        this.total = total;
        this.pageNum = pageNum;
    }

    public PageDTO(T data, Long total, Integer pageNum) {
        this.list = Collections.singletonList(data);
        this.total = total;
        this.pageNum = pageNum;
    }
    /**
     * 默认方法 没有数据的时候请用这个
     *
     * @param pageNum 当前页
     * @return 无数据的时候返回对象
     */
    public static <T> PageDTO<T> noData(Integer pageNum) {
        return new PageDTO<>(new ArrayList<>(), 0L, pageNum);
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("list", list)
                .append("total", total)
                .append("pageNum", pageNum)
                .toString();
    }
}
