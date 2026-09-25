package com.labsphere.Repository;

import com.labsphere.Entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubmissionRepo extends JpaRepository<Submission,Long> {

    List<Submission> findByStudentId(Long studentId);

    List<Submission> findByPracticalId(Long practicalId);
}
