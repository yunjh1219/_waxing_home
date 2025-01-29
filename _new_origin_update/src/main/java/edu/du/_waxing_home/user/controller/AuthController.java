package edu.du._waxing_home.user.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    //메인페이지
    @GetMapping("/")
    public String main() {
        // SecurityContext에서 인증 정보를 가져옴
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            System.out.println("Authenticated user: " + authentication.getName());
        } else {
            System.out.println("No authentication found.");
        }

        return "pages/main";
    }

    // 로그인 페이지
    @GetMapping("/api/login")
    public String loginPage() {
        return "pages/auth/login";
    }

    @GetMapping("/api/signup")
    public String signOnePage(){
        return "pages/auth/signupone";
    }



}
