package com.labsphere.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Subject")
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subName;
    @ManyToOne
    @JoinColumn(name = "Academic_Year_id")
    private AcademicYear academicYear;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private User professor;

}
