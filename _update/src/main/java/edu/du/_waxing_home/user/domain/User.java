package edu.du._waxing_home.user.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Long id;

    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;

    @Enumerated(EnumType.STRING)
    private Role role; // user role (admin, user)

}
