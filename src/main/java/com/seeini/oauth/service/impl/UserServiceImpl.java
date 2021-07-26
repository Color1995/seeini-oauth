package com.seeini.oauth.service.impl;

import com.seeini.common.jwt.JwtUtil;
import com.seeini.common.request.RequestData;
import com.seeini.common.response.ResponseData;
import com.seeini.common.response.ResponseStatus;
import com.seeini.common.response.ResponseUtil;
import com.seeini.oauth.mapper.UserMapper;
import com.seeini.oauth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.seeini.oauth.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    public int deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    
    public int insert(User user) {
        return userMapper.insert(user);
    }

    
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectById(id);
    }

    public User getUserByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public boolean hasUser() {

        User user = userMapper.selectByAccount(null);

        return false;
    }

    /**
     * 用户校验
     *
     * @param user
     * @return
     */
    @Override
    public ResponseData checkUser(User user) {

        Map<String, Object> resultMap = new HashMap<>();
        try {
//            redisTemplate.
            User dbUser = userMapper.selectByAccount(user.getAccount());
            if (dbUser.getAccount().equals(user.getAccount()) && dbUser.getPassword().equals(user.getPassword())) {
                // 生产的token
                String token = JwtUtil.generateSalt();
                resultMap.put("token",token);
                ResponseUtil.success(resultMap);
            } else {
                ResponseUtil.error(ResponseStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            return ResponseUtil.error();
        }
        // TODO 未知错误
        return ResponseUtil.error();
    }


    //    public String generateJwtToken(String username){
//        //加密JWT的盐
//        String salt = "0805c99fd2634c80b2cde8c7e4124468";
//        //redis缓存salt
//        stringRedisTemplate.opsForValue().set("token:"+username, salt, 3600, TimeUnit.SECONDS);
//        return JwtUtils.sign(username,salt,60*60);//生成jwt token，设置过期时间为1小时
//    }
//
//    /*
//     * 获取上次token生成时的salt值和登录用户信息*/
//    public User getJwtToken(String username) {
////        String salt = "9723612f53";
//        //从数据库或者缓存中取出jwt token生成时用的salt
//        String salt = stringRedisTemplate.opsForValue().get("token:"+username);
//        User User = this.getUserInfo(username);
//        User.setSalt(salt);
//        return User;
//    }
//
//    /**
//     * 获取数据库中保存的用户信息，主要是加密后的密码.这里省去了DB操作，直接生成了用户信息
//     * @param username
//     * @return
//     */
//    public User getUserInfo(String username){
//        User user =  new User();
//        user.setUserId(1L);
//        user.setUsername("admin");
//        //模拟对密码加密
//        user.setEncryptPwd(new Sha256Hash("admin123",encryptSalt).toHex());
//        lgger.debug("UserService: [{}]",user.toString());
//        return user;
//    }
//
//    /**清除token信息*/
//    public void deleteLogInfo(String username){
//        // 删除数据库或者缓存中保存的salt
////        stringRedisTemplate.delete("token:"+username);
//    }
//
//    /**获取用户角色列表，强烈建议从缓存中获取*/
//    public List<String> getUserRoles(Long userId){
//        //模拟admin角色
//        return Arrays.asList("admin");
//    }
}
