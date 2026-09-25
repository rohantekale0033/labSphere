package com.labsphere.Controller;

import com.labsphere.Entity.Practical;
import com.labsphere.Service.PracticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Practical")
public class PracticalController {

    @Autowired
    private PracticalService practicalService;

    @ PostMapping("/addPractical")
    public ResponseEntity<String> getPracticals (@RequestBody Practical practical){
      practicalService.addPractical(practical);
      return new ResponseEntity<>("practical added successfully " , HttpStatus.CREATED);
    }

    @GetMapping("/getPractical")
    public ResponseEntity<List<Practical>> getPracticals (){
      List<Practical> practicalList = practicalService.getAllPractical();
        return new ResponseEntity<>( practicalList , HttpStatus.OK);
    }

    @GetMapping("/{practicalId}/manual")
    public ResponseEntity<String> getManual(@PathVariable Long practicalId) {
        return new ResponseEntity<>(
                practicalService.getManual(practicalId),
                HttpStatus.OK
        );
    }
}
