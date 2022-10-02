package com.tedu.java.controller.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： zyy
 * @date： 2022/9/13 22:01
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@RestController
public class UserController {
    @GetMapping("/index")
    public String index(){
        return "hello index";
    }
}
