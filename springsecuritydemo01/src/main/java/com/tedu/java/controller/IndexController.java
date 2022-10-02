package com.tedu.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author： zyy
 * @date： 2022/9/6 21:18
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
