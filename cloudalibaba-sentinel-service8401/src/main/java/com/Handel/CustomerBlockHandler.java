package com.Handel;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.pojo.CommonResult;

/**
 * 自定义限流处理类
 * @author Administrator
 * @create 2021-02-07 16:18
 */
public class CustomerBlockHandler {
    public static CommonResult handleException(BlockException exception) {
        return new CommonResult(2020, "自定义限流处理信息....CustomerBlockHandler");

    }
}
