package edu.du._waxing_home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // PasswordEncoder 설정
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // AuthenticationManager 설정
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // HTTP 보안 설정
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login", "/signup", "/css/**", "/js/**", "/img/**").permitAll()  // 로그인, 회원가입, CSS, JS, 이미지 파일은 인증 없이 접근 가능
                .antMatchers("/admin/**").hasRole("ADMIN")  // /admin 하위 경로는 ADMIN 역할을 가진 사용자만 접근 가능
                .anyRequest().authenticated()  // 나머지 경로는 인증 필요
                .and()
                .formLogin()
                .loginPage("/login")  // 사용자 정의 로그인 페이지
                .permitAll()  // 로그인 페이지는 누구나 접근 가능
                .defaultSuccessUrl("/", true) // 로그인 성공 시 리다이렉트될 페이지 (홈페이지 등)
                .and()
                .logout()
                .permitAll();  // 로그아웃 페이지는 누구나 접근 가능
    }

    // UserDetailsService 설정 (DB 연동)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder()) // 암호화된 비밀번호 처리
                .usersByUsernameQuery("SELECT username, password, role FROM user WHERE username = ?");
    }
}