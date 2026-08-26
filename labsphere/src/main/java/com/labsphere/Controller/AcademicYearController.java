package com.labsphere.Controller;


import com.labsphere.Entity.AcademicYear;
import com.labsphere.Service.AcademicYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AcademicYear")
public class AcademicYearController {

    @Autowired
    private AcademicYearService academicYearService;

    @PostMapping("/addYear")
    public ResponseEntity<String> addYear(@RequestBody AcademicYear academicYear){
      academicYearService.addYear(academicYear);
        return new ResponseEntity<>("AcademicYear added", HttpStatus.CREATED);
    }

    @GetMapping("/getYear")
    public ResponseEntity<List<AcademicYear>> getAllYear(){
        List<AcademicYear> academicYearList = academicYearService.getAllYears();
        return new ResponseEntity<>(academicYearList, HttpStatus.OK);
    }

}
