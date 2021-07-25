package com.seeini.oauth.service;

import com.seeini.oauth.mapper.UserMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.seeini.oauth.entity.User;
@Service
public class UserService{

    @Resource
    private UserMapper userMapper;

    
    public int deleteByPrimaryKey(String userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    
    public int insert(User record) {
        return userMapper.insert(record);
    }

    
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    
    public User selectByPrimaryKey(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

}
