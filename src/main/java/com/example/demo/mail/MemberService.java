package com.example.demo.mail;

import com.example.demo.UserInfo;
import com.example.demo.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MemberService {

    @Autowired
    private UserMapper userMapper;

    public void signUp(UserInfo userInfo) {
        userMapper.save(userInfo);
    }

    public void updateAuthKey(HashMap<String, String> map) {
        userMapper.updateAuthKey(map);
    }
}
