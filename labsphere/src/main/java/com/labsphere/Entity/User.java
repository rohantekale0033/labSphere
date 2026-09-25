package com.labsphere.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType role;
    private int academicYear;
    private UserStatus Status;


}
