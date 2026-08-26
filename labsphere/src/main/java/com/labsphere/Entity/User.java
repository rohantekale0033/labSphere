package com.labsphere.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserType role;
    private int academicYear;
    private UserStatus Status;


}
