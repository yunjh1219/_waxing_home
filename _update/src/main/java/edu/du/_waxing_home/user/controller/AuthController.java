package edu.du._waxing_home.user.controller;

import edu.du._waxing_home.user.domain.User;
import edu.du._waxing_home.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // 로그인 페이지 표시
    @GetMapping("/auth/login")
    public String login() {
        return "auth/login";  // 로그인 페이지를 반환
    }

    // 회원가입 요청
    @PostMapping("/auth/register")
    public String register(@RequestBody User user) {
        userService.registerUser(user);
        return "User registered successfully!";
    }

}
