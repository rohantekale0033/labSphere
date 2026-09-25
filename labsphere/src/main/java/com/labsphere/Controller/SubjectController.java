package com.labsphere.Controller;

import com.labsphere.Entity.Subject;
import com.labsphere.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/addSubject")
    public ResponseEntity<String> getSubjects (@RequestBody Subject subject){
        subjectService.addSubject(subject);
        return new ResponseEntity<>("subject added " , HttpStatus.CREATED);
    }

    @GetMapping("/getSubject")
    public ResponseEntity<List<Subject>> getAllSubject(){
     List<Subject> subjectList  = subjectService.getAllSubject();
     return new ResponseEntity<>(subjectList,HttpStatus.OK);
    }



}
