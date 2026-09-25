package com.labsphere.ServiceImpl;

import com.labsphere.Entity.PracticalProgress;
import com.labsphere.Entity.PracticalStatus;
import com.labsphere.Entity.Submission;
import com.labsphere.Repository.PracticalProgressRepo;
import com.labsphere.Repository.SubmissionRepo;
import com.labsphere.Service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private SubmissionRepo submissionRepo;
    private PracticalProgressRepo practicalProgressRepo;

    @Override
    public String submitSolution(Submission submission) {
        submissionRepo.save(submission);

        Long studentId = submission.getStudent().getId();
        Long practicalId = submission.getPractical().getId();

        Optional<PracticalProgress> optionalProgress =
                practicalProgressRepo.findByStudentIdAndPracticalId(
                        studentId,
                        practicalId
                );

        if (optionalProgress.isPresent()) {

            PracticalProgress progress = optionalProgress.get();

            progress.setStatus(PracticalStatus.COMPLETED);
            progress.setCompletedAt(LocalDateTime.now());

            practicalProgressRepo.save(progress);
        }
        return "Solution Submitted Successfully";
    }

    @Override
    public List<Submission> getSubmissionByStudent(Long studentId) {
        return submissionRepo.findByStudentId(studentId);
    }

    @Override
    public List<Submission> getSubmissionByPractical(Long practicalId) {
        return submissionRepo.findByPracticalId(practicalId);
    }

    @Override
    public List<Submission> getAllSubmission() {
        return submissionRepo.findAll();
    }
}
