package com.labsphere.Repository;

import com.labsphere.Entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepo extends JpaRepository<Submission,Integer> {
}
