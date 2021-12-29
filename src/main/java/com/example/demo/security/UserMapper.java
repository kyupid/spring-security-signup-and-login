package com.example.demo.security;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("select * from member where email=#{email}")
    Optional<UserInfo> findByEmail(@Param("email") String email);
}
