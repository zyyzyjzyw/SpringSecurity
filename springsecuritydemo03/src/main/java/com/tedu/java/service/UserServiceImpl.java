package com.tedu.java.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedu.java.dao.UserMapper;
import com.tedu.java.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author： zyy
 * @date： 2022/9/13 21:48
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //调用userMapper方法根据用户名查询数据库
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Users users = userMapper.selectOne(wrapper);
        //做判断
        if(users==null){
            throw new UsernameNotFoundException("用户名不存在!");
        }
        List<GrantedAuthority> list = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        //从查询出的users对象，得到用户名和密码
        return new User(users.getUsername(),new BCryptPasswordEncoder().encode(users.getPassword()),list);
    }
}
