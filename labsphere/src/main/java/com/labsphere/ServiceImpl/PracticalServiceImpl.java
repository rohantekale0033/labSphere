package com.labsphere.ServiceImpl;

import com.labsphere.Entity.Practical;
import com.labsphere.Repository.PracticalRepo;
import com.labsphere.Service.PracticalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracticalServiceImpl implements PracticalService {

    @Autowired
    private PracticalRepo practicalRepo;

    @Override
    public String addPractical(Practical practical) {
        Practical addPractical = practicalRepo.save(practical);
        return "prctical title successfully ";

    }

    @Override
    public List<Practical> getAllPractical() {
        List<Practical> practicalList = practicalRepo.findAll();
        return practicalList;
    }

    @Override
    public String getManual(Long practicalId) {

        Optional<Practical> optionalPractical =
                practicalRepo.findById(practicalId);

        if (optionalPractical.isPresent()) {

            Practical practical = optionalPractical.get();

            return practical.getLabManualPath();
        }

        return "Manual not found";
    }
}
