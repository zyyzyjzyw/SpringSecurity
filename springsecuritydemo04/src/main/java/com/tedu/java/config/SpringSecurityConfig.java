package com.tedu.java.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author： zyy
 * @date： 2022/9/17 9:59
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());
    }
    @Bean
    PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //退出
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/test/hello").permitAll();
        //配置没有权限跳转的页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        http.formLogin()//定义自己编写的登录页面
        .loginPage("/login.html")//登录页面设置
        .loginProcessingUrl("/user/login")//登录访问路径
        .defaultSuccessUrl("/success.html").permitAll()//登录成功后，跳转后的路径
        .and().authorizeRequests().antMatchers("/","/test/hello","/user/login").permitAll()//设置哪些访问路径不需要验证
                //当前登录用户，只有具有admins权限才可以访问这个路径
                //1.hasAuthority方法

         //.antMatchers("/test/index").hasAuthority("admins")//只有权限为admins时才可以访问
                //2.hasAnyAuthority方法
                //.antMatchers("/test/index").hasAnyAuthority("admins,role")//具备一种权限就可以
                //3.hasRole方法
                //.antMatchers("/test/index").hasRole("role")
                //4.hasAnyRole方法
                .antMatchers("/test/index").hasAnyRole("roles")
        .anyRequest().authenticated()
                .and().csrf().disable();//关闭csrf防护
    }
}
