package com.example.demo.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // 컨트롤러 어노테이션 선언
@RequestMapping("/email") // 공통적인 매핑 주소
public class EmailController {

    @Autowired
    EmailService emailService; // 서비스를 호출하기위한 의존성 주입

    @PostMapping("/send") // 확인 (메일발송) 버튼을 누르면 맵핑되는 메소드
    public int send(@RequestBody EmailDTO dto) {
        return emailService.sendMail(dto);
    }
}
