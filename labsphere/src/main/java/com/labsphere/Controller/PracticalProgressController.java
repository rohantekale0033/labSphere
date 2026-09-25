package com.labsphere.Controller;

import com.labsphere.Entity.PracticalProgress;
import com.labsphere.Service.PracticalProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller")
public class PracticalProgressController {

    @Autowired
    private PracticalProgressService practicalProgressService;

    @PostMapping("/start")
    public ResponseEntity<String> startPractical(@RequestBody PracticalProgress practicalProgress){
        practicalProgressService.startPractical(practicalProgress);
        return new ResponseEntity<>("practical Started", HttpStatus.CREATED);
    }

    @PutMapping("/complete/{progressId}")
    public ResponseEntity<String> completePractical(@PathVariable Long progressId ){
        String result = practicalProgressService.completePractical(progressId);
        return new ResponseEntity<>(result , HttpStatus.OK);
    }

    @PutMapping("/student/{studentId}")
    public ResponseEntity<List< PracticalProgress>> getProgressByStudent(@PathVariable Long studentId ) {
        List<PracticalProgress> progress = practicalProgressService.getProgressByStudent(studentId);
        return new ResponseEntity<>(progress, HttpStatus.OK);
    }

    @PutMapping("/practical/{practicalId}")
    public ResponseEntity<List< PracticalProgress>> getProgressBypractical(@PathVariable Long practicalId) {
        List<PracticalProgress> progress = practicalProgressService.getProgressByPrqctical(practicalId);
        return new ResponseEntity<>(progress, HttpStatus.OK);
    }

    @PostMapping("/start/{studentId}/{practicalId}")
    public ResponseEntity<PracticalProgress> startPractical(
            @PathVariable Long studentId,
            @PathVariable Long practicalId) {

        PracticalProgress progress =
                practicalProgressService.startPractical(studentId, practicalId);

        return new ResponseEntity<>(progress, HttpStatus.CREATED);
    }

}
