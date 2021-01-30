package com.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Administrator
 * @create 2021-01-29 17:57
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Payment {

    private long id;
    private String serial;

}
