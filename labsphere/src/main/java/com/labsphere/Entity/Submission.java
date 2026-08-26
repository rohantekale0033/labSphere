package com.labsphere.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "submission")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "practical_id")
    private Practical practical;

    @Enumerated(EnumType.STRING)
    private SubmissionStatus submissionStatus;

    private LocalDateTime submittedAt;

}
