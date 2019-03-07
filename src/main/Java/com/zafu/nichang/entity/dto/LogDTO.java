package com.zafu.nichang.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 倪畅
 * @date 2019/2/22 15:53
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO {

    private String message;
    private String timestamp;
    private String threadName;
    private String className;
    private String level;
    private int size;


}
