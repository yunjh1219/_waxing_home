package edu.du._waxing_home.user.service;

import edu.du._waxing_home.user.domain.Role;
import edu.du._waxing_home.user.domain.User;
import edu.du._waxing_home.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 회원가입
    public User registerUser(User user) {
        // 기본적으로 ROLE_USER로 설정
        user.setRole(Role.ROLE_USER);
        return userRepository.save(user);
    }

    // 사용자 조회
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 사용자 이름으로 조회
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }

    // 관리자 역할 확인
    public boolean isAdmin(User user) {
        return user.getRole() == Role.ROLE_ADMIN;
    }
}