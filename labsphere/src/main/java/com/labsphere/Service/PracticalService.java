package com.labsphere.Service;

import com.labsphere.Entity.Practical;
import com.labsphere.Entity.Subject;

import java.util.List;

public interface PracticalService {

    String addPractical (Practical practical);
    List<Practical> getAllPractical();

    String getManual(Long practicalId);
}
