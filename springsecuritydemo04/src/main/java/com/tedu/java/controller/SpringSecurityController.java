package com.tedu.java.controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author： zyy
 * @date： 2022/9/17 10:15
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Controller
@RequestMapping("/test")
public class SpringSecurityController {
    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello springSecurity";
    }
    @GetMapping("index")
    @ResponseBody
    public String index(){
        return "hello index";
    }

    @GetMapping("update")
    @ResponseBody
    //@Secured({"ROLE_role","ROLE_manager"})
    //@PreAuthorize("hasAnyAuthority('admins')")
    @PostAuthorize("hasAnyAuthority('admins')")
    public String update(){
        System.out.println("update......");
        return "hello update";
    }
}
