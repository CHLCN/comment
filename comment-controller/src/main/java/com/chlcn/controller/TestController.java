package com.chlcn.controller;

import com.chlcn.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * comment controller
 */
@RestController
@RequestMapping("/comment")
@Slf4j
public class TestController {
//    Logger log = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private IUserService userService;
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        int userTotal = userService.countUserTotal();
        log.info("打印日志");
        // 查询用户总人数
        return "用户总人数：" + userTotal;
    }

}
