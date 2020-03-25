package org.online.learn.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.online.learn.domain.model.User;
import org.online.learn.user.dao.UserDao;
import org.online.learn.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int register(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public Map<Integer, Map<String, Object>> getUserInfo(Set userids) {
        return userDao.getUserInfo(userids);
    }


}
