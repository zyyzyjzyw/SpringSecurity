package com.tedu.java.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tedu.java.pojo.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<Users> {
}
