package com.tedu.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author： zyy
 * @date： 2022/9/13 21:09
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Controller
public class SpringSecurityController {
    @GetMapping("/index")
    @ResponseBody
    public String index(){
        return "Hello Index!";
    }
}
