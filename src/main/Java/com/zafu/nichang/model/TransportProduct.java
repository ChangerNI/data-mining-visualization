package com.zafu.nichang.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：倪畅
 * @date ：Created in 2019/1/31 21:41
 * @description：
 * @modified By：
 * @version: $ 产品流通类
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportProduct {
    private String type;
    private String province;
    private Double percent;
    private Integer totalKG;
}
