package com.zerobase.lms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// 인터넷주소와 물리적인파일 매핑
@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {

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
