package com.labsphere.Repository;

import com.labsphere.Entity.PracticalProgress;
import com.labsphere.Entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PracticalProgressRepo extends JpaRepository<PracticalProgress,Long> {

    List<PracticalProgress> findByStudentId(Long studentId);

    List<PracticalProgress> findByPracticalId(Long practicalId);

    Optional<PracticalProgress> findByStudentIdAndPracticalId(
            Long studentId,
            Long practicalId
    );
}
