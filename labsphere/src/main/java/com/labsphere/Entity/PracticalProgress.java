package com.labsphere.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "practical_progress")
public class PracticalProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private User student;

    @ManyToOne
    @JoinColumn(name = "practical_id", nullable = false)
    private Practical practical;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PracticalStatus status;

    private LocalDateTime startedAt;

    private LocalDateTime completedAt;
}
