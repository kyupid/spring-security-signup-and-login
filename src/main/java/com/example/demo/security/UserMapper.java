package com.example.demo.security;

import org.apache.ibatis.annotations.*;

import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("select * from member where email=#{email}")
    Optional<UserInfo> findByEmail(@Param("email") String email);

    @Insert("insert into member(email, password, auth) values( #{userInfo.email}, #{userInfo.password}, #{userInfo.auth} )")
    @Options(useGeneratedKeys = true, keyProperty = "code")
    UserInfo save(@Param("userInfo") UserInfo userInfo);
}
