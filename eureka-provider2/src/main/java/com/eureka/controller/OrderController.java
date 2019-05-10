package com.eureka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by smlz on 2019/3/26.
 */
@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {


    @Value("${myconfigtest}") // git配置文件里的key
    public String myconfigtest;

    @Value("${busi.ops}")
    private String isNewLogic;

    /**
     * 测试手动刷新
     *
     * @return
     */
    @RequestMapping("/testManualRefresh")
    public String testManualRefresh() {
        if (isNewLogic.equals("Y")) {
            System.out.println("走新逻辑................");
        } else {
            System.out.println("走老的业务逻辑...........");
        }

        return isNewLogic;
    }

}
