package com.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @create 2021-02-07 0:34
 */
@RestController
public class FlowLimitController {
    //测试qps
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }
    //测试线程数
    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }
    //测试流控模式
    @GetMapping("/testC")
    public String testC() {

        return "------testC";
    }
    @GetMapping("/testD")
    public String testD() {

        return "------testD";
    }

    /**
     * 热点规则的索引数从零开始，顺序按照参数列表
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {
//        int age = 10/0;
        return "------testHotKey";
    }

    //兜底方法
    public String deal_testHotKey (String p1, String p2, BlockException exception){
        return "------deal_testHotKey,o(╥﹏╥)o";
    }

//    public String deal(String p1,String p2){
//        return "======出错了=======";
//    }



}



