package edu.du._waxing_home.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    //메인페이지
    @GetMapping("/")
    public String home() {
        return "pages/main/main";
    }

}
