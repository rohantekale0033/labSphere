package com.labsphere.Service;

import com.labsphere.Entity.AcademicYear;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface AcademicYearService {

     String addYear(AcademicYear academicYear);
     List<AcademicYear> getAllYears();


}
