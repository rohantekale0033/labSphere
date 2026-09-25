package com.labsphere.Service;

import com.labsphere.Entity.Subject;

import java.util.List;

public interface SubjectService {
     String  addSubject(Subject subject);
    List<Subject> getAllSubject();
}
