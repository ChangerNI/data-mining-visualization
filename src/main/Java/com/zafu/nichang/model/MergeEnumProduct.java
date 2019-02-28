package com.zafu.nichang.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 倪畅
 * @date 2019/2/28 9:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MergeEnumProduct {

    private String label;
    private String value;
    private List<MergeEnumProduct> children;

}
