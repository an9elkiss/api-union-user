package com.an9elkiss.api.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.an9elkiss.api.user.command.UserCmd;

@Mapper
public interface UserDao {


	List<UserCmd> findUsers(Map<String, ?> searchParams);

}
