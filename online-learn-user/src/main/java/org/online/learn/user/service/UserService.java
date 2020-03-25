package org.online.learn.user.service;

import org.online.learn.domain.model.User;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserService {
    int register(User user);
    Map<Integer, Map<String, Object>> getUserInfo(Set userids);
}
