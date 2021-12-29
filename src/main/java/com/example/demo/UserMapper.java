package com.example.demo;

import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface UserMapper {

    @Select("select * from user_info where email=#{email}")
    Optional<UserInfo> findByEmail(@Param("email") String email);

    @Insert("insert into user_info(email, password, auth) values( #{userInfo.email}, #{userInfo.password}, #{userInfo.auth} )")
    @Options(useGeneratedKeys = true, keyProperty = "code")
    Long save(@Param("userInfo") UserInfo userInfo);
}
