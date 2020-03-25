package org.online.learn.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.online.learn.domain.common.Callback;
import org.online.learn.domain.common.Result;
import org.online.learn.domain.common.ReturnCode;
import org.online.learn.domain.model.User;
import org.online.learn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Slf4j
@RestController
@RequestMapping("/user")
@Api(value = "UserController", tags = "用户API", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册服务
     * @param user
     * @return
     */
    @RequestMapping(value="/register",method = RequestMethod.POST)
    @ApiOperation(value = "用户注册", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Callback<User> register(@RequestBody User user){
        if(user.getId()!=null){
            user.setId(null);
        }
        if(user.getCreateTime()==null){
            user.setCreateTime(new Date());
        }
        if(user.getUpdateTime()==null){
            user.setUpdateTime(new Date());
        }
        int i=userService.register(user);
        if(i>0) {
            log.info("user id:" + user.getId());
            return new Callback<User>(ReturnCode.OPT_SUCESS, user, true);
        }else{
            return new Callback<User>(ReturnCode.OPT_ERROE, null, false);
        }
    }

    @RequestMapping(value="/getuserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "查询用户信息", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Callback<Map<Integer, Map<String, Object>>> getUserInfo(@RequestBody HashSet<Integer> userids){
        Map<Integer, Map<String, Object>> map;
        try{
            log.info("userids:"+userids.size());
            map=userService.getUserInfo(userids);
            log.info("map:"+map.size());
            return new Callback<Map<Integer, Map<String, Object>>>(ReturnCode.OPT_SUCESS, map, true);
        }catch (Exception e){
            log.error(e.getMessage());
            return new Callback<Map<Integer, Map<String, Object>>>(ReturnCode.OPT_ERROE, null, false);
        }
    }
}
