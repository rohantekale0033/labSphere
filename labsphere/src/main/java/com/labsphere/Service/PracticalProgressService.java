package com.labsphere.Service;

import com.labsphere.Entity.Practical;
import com.labsphere.Entity.PracticalProgress;

import java.util.List;

public interface PracticalProgressService {

    String startPractical (PracticalProgress practicalProgress);

    String completePractical( Long progressId);

    List<PracticalProgress> getProgressByStudent(Long studentId);

    List<PracticalProgress> getProgressByPrqctical(Long practicalId);

    PracticalProgress startPractical(Long studentId, Long practicalId);


}
