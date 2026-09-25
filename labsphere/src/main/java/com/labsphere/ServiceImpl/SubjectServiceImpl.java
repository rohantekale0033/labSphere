package com.labsphere.ServiceImpl;

import com.labsphere.Entity.Subject;
import com.labsphere.Repository.SubjectRepo;
import com.labsphere.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepo subjectRepo;

    @Override
    public String addSubject(Subject subject) {
        Subject addSubject = subjectRepo.save(subject);
        return "subject added successfully ";
    }

    @Override
    public List<Subject> getAllSubject() {
        List<Subject> subjectList = subjectRepo.findAll();
        return subjectList;
    }
}
