package com.labsphere.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "practical")
public class Practical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Integer practicalNo;
    private String experiementTitle;
    private String labManualPath;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;


}
