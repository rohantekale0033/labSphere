package com.labsphere.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "practical")
public class Practical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer practicalNo;
    private String experiementTitle;
    private String labManualPath;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;


}
