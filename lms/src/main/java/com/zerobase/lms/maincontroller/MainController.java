package com.zerobase.lms.maincontroller;

import com.zerobase.lms.components.MailComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 인터넷주소와 물리적인파일 매핑
@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponent mailComponents;

    @Value("${spring.mail.username}")
    private String myEmail;

    @RequestMapping("/")
    public String index() {

//        String email = myEmail;
//        String subject = "안녕하세요 제로베이스입니다!";
//        String text = "<p> 안녕하세요. </p> <p> 반갑습니다. </p>";
//        mailComponents.sendMail(email, subject, text);
        return "index";  // 자동으로 매핑되게 해줌! templates의 index 파일로!
    }

    @RequestMapping("/error/denied")
    public String errorDenied() {
        return "error/denied";
    }

}
