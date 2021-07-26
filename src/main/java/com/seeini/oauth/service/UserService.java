package com.seeini.oauth.service;

import com.seeini.common.request.RequestData;
import com.seeini.common.response.ResponseData;
import com.seeini.oauth.entity.User;

/**
 * @Author Vincent
 * @Date 2021/7/26 13:17
 * @Version 1.0
 * @Description
 */
public interface UserService {

    boolean hasUser();

    /**
     * 用户校验
     * @param user
     * @return
     */
    ResponseData checkUser(User user);

    public User getUserByAccount(String account);
}
