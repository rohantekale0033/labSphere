package com.labsphere.Controller;

import com.labsphere.Entity.Submission;
import com.labsphere.Service.SubmissionService;
import com.labsphere.ServiceImpl.SubmissionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitSolution(@RequestBody Submission submission){
        String response = submissionService.submitSolution(submission);
        return new ResponseEntity<>("solution submitted successfully", HttpStatus.CREATED);
    }
    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Submission>> getSubmissionByStudentId(@PathVariable long studentId){
        List<Submission> submissionList = submissionService.getSubmissionByStudent(studentId);
        return new ResponseEntity<>(submissionList, HttpStatus.OK);
    }

    @GetMapping("/practical/{practicalId}")
    public ResponseEntity<List<Submission>> getSubmissionByPractical(@PathVariable long practicalId){
        List<Submission> submissionList = submissionService.getSubmissionByPractical(practicalId);
        return new ResponseEntity<>(submissionList, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Submission>> getAllSubmission (){
        List<Submission> submissionList = submissionService.getAllSubmission();
        return new ResponseEntity<>(submissionList, HttpStatus.OK);
    }






}
