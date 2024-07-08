package com.zerobase.lms;

import com.zerobase.lms.component.MailComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 인터넷주소와 물리적인파일 매핑
@RequiredArgsConstructor
@Controller
public class MainController {

    private final MailComponent mailComponents;

    @RequestMapping("/")
    public String index() {

        String email = "huejo@lalala.ac.kr";
        String subject = "안녕하세요 제로베이스입니다!";
        String text = "<p> 안녕하세요. </p> <p> 반갑습니다. </p>";
        mailComponents.sendMail(email, subject, text);
        return "index";  // 자동으로 매핑되게 해줌! templates의 index 파일로!
    }


    //request -> web -> server
    //response -> server -> web
    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");

        PrintWriter printWriter = response.getWriter();

        String msg = "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "</head>"
                + "<body>"
                + "<p> Hello World!</p> <p>This is zerobase website</p>"
                + "<p> 안녕~! </p>"
                + "</body>"
                + "</html>";

        printWriter.write(msg);
        printWriter.close();
    }

}
