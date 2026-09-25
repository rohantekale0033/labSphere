package com.labsphere.Service;

import com.labsphere.Entity.Submission;


import java.util.List;

public interface SubmissionService {

     String submitSolution(Submission submission);
     List<Submission> getSubmissionByStudent(Long studentId);
     List<Submission> getSubmissionByPractical(Long practicalId);
     List<Submission> getAllSubmission();

}
