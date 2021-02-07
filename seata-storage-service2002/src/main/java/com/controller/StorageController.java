package com.controller;

import com.pojo.CommonResult;
import com.service.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @create 2021-02-07 21:34
 */
@RestController
public class StorageController {

    @Autowired
    private StorageServiceImpl storageService;


    //扣减库存
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }
}

