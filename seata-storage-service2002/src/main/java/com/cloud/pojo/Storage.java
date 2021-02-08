package com.cloud.pojo;

import lombok.Data;

/**
 * @author Administrator
 * @create 2021-02-07 21:23
 */
@Data
public class Storage {

    private Long id;

    // 产品id
    private Long productId;

    //总库存
    private Integer total;


    //已用库存
    private Integer used;


    //剩余库存
    private Integer residue;
}
