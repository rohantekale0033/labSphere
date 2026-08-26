package com.labsphere.ServiceImpl;

import com.labsphere.Entity.AcademicYear;
import com.labsphere.Repository.AcademicYearRepo;
import com.labsphere.Service.AcademicYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcademicYearServiceImpl implements AcademicYearService {

    @Autowired
    private AcademicYearRepo academicYearRepo;
    @Override
    public String addYear(AcademicYear academicYear) {
       AcademicYear year = academicYearRepo.save(academicYear);
       return "academic details saved ";
    }

    @Override
    public List<AcademicYear> getAllYears() {
         List<AcademicYear> academicYearList = academicYearRepo.findAll();
        return academicYearList;
    }


}
