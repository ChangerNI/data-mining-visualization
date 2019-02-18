package com.zafu.nichang.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：倪畅
 * @date ：Created in 2019/2/2 19:03
 * @description：未来七天产品类
 * @modified By：
 * @version: 1.0$
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisProduct {
    private String dateTime;
    private Double minPrice;
    private Double avgPrice;
    private Double maxPrice;

}
