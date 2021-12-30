package com.example.demo.mail;

import com.example.demo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MailSendService mss;

    @Transactional
    @PostMapping("/member/signUp")
    public void signUp(@RequestBody UserInfo userInfo){
        // DB에 기본정보 insert
        memberService.signUp(userInfo);

        System.out.println(userInfo.toString());

        //임의의 authKey 생성 & 이메일 발송
        String authKey = mss.sendAuthMail(userInfo.getEmail());
        userInfo.setAuthKey(authKey);

        HashMap<String, String> map = new HashMap<>();
        map.put("email", userInfo.getEmail());
        map.put("authKey", userInfo.getAuthKey());
        System.out.println(map);

        //DB에 authKey 업데이트
        memberService.updateAuthKey(map);
    }
}
