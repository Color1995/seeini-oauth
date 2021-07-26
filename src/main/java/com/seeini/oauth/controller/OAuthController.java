package com.seeini.oauth.controller;

import com.google.gson.Gson;
import com.seeini.common.request.RequestData;
import com.seeini.common.response.ResponseData;
import com.seeini.oauth.entity.User;
import com.seeini.oauth.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Author Vincent
 * @Date 2021/7/26 10:08
 * @Version 1.0
 * @Description
 */
@RestController
public class OAuthController {

    @Resource
    private UserService userService;

    private Gson gson = new Gson();

    @PostMapping(value = "ssoLogin")
    public ResponseData login(@RequestBody RequestData requestData){

        User user = gson.fromJson(requestData.getData().toString(), User.class);

        return userService.checkUser(user);
    }


//    @PostMapping(value = "check")
//    public ResponseData check(@RequestBody RequestData requestData){
//
////        gson.fromJson(requestData.getData(),Map.class);
//        Map map = (Map) requestData.getData();
//        Object infoSecret = (String) map.get("infoSecret");
//
//        return userService.checkUser();
//    }
}
