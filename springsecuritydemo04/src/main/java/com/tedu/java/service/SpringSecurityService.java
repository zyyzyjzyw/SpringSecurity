package com.tedu.java.service;

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
 * @date： 2022/9/13 21:02
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Service("userDetailsService")
public class SpringSecurityService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> list = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_role");
        return new User("zyy",new BCryptPasswordEncoder().encode("123456"),list);
    }
}
