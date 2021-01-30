package com.cloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Administrator
 * @create 2021-01-29 17:58
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;
public CommonResult(Integer code,String message){
       this.code=code;
       this.message=message;
}
}
