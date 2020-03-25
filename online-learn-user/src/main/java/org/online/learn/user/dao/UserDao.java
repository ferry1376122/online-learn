package org.online.learn.user.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.online.learn.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface UserDao {
    int saveUser(User user);
    @MapKey("id")
    Map<Integer,Map<String, Object>> getUserInfo(@Param("userids") Set userids);
}
