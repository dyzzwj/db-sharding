package com.dyzwj.dbsharding.dao;

import com.dyzwj.dbsharding.po.UserPO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhengwenjie
 * @version 1.0.0
 * @ClassName UserDao.java
 * @Description TODO
 * @createTime 2020年05月02日 19:09:00
 */
@Mapper
public interface UserDao {

    @Insert("insert into t_user(user_id,fullname,user_type) values(#{userId},#{fullname},#{userType})")
    int insertUser(UserPO userPO);
}
