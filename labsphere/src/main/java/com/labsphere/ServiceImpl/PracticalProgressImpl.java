package com.labsphere.ServiceImpl;

import com.labsphere.Entity.Practical;
import com.labsphere.Entity.PracticalProgress;
import com.labsphere.Entity.PracticalStatus;
import com.labsphere.Entity.User;
import com.labsphere.Repository.PracticalProgressRepo;
import com.labsphere.Repository.PracticalRepo;
import com.labsphere.Repository.UserRepo;
import com.labsphere.Service.PracticalProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PracticalProgressImpl implements PracticalProgressService {

    @Autowired
    private PracticalProgressRepo practicalProgressRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PracticalRepo practicalRepo;

    @Override
    public String startPractical(PracticalProgress practicalProgress) {
        practicalProgressRepo.save(practicalProgress);
        return "progress saved ";
    }

    @Override
    public String completePractical(Long progressId) {
        Optional<PracticalProgress> optionalProgress = practicalProgressRepo.findById(progressId);
        if (optionalProgress.isPresent()) {
            PracticalProgress progress = optionalProgress.get();

            progress.setStatus(PracticalStatus.COMPLETED);
            progress.setCompletedAt(LocalDateTime.now());

            practicalProgressRepo.save(progress);

            return "Practical completed successfully";
        }
        return "Progress not found";
    }

        @Override
        public List<PracticalProgress> getProgressByStudent (Long studentId){
            return practicalProgressRepo.findByStudentId(studentId);
        }

        @Override
        public List<PracticalProgress> getProgressByPrqctical (Long practicalId){
            return practicalProgressRepo.findByPracticalId(practicalId);

        }

    @Override
    public PracticalProgress startPractical(Long studentId, Long practicalId) {
        Optional<PracticalProgress> existing =
                practicalProgressRepo.findByStudentIdAndPracticalId(
                        studentId, practicalId);

        if (existing.isPresent()) {
            return existing.get();
        }
        User student = userRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Practical practical = practicalRepo.findById(practicalId)
                .orElseThrow(() -> new RuntimeException("Practical not found"));


        PracticalProgress progress = new PracticalProgress();
        progress.setStudent(student);
        progress.setPractical(practical);
        progress.setStatus(PracticalStatus.STARTED);
        progress.setStartedAt(LocalDateTime.now());

        return practicalProgressRepo.save(progress);

    }

}
