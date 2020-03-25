package org.online.learn.selectCourse.feign;

import io.swagger.annotations.ApiOperation;
import org.online.learn.domain.common.Callback;
import org.online.learn.domain.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@FeignClient(value = "user-server")
public interface UserFeignInterface {
    @RequestMapping(value="/user/getuserInfo",method = RequestMethod.POST)
    public Callback<Map<Integer, Map<String, Object>>> getUserInfo(@RequestBody Set<Integer> userids);
}
