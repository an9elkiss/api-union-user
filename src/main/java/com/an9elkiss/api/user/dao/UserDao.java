package com.an9elkiss.api.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.an9elkiss.api.user.command.UserCmd;
import com.an9elkiss.api.user.command.UserPersonCmd;

@Mapper
public interface UserDao{

    List<UserCmd> findUsers(Map<String, ?> searchParams);

    List<UserPersonCmd> findUserPerson();

    /**
     * 更新用户密码
     * 
     * @param userCmd
     * @return
     */
    int updatePassword(UserCmd userCmd);
}
