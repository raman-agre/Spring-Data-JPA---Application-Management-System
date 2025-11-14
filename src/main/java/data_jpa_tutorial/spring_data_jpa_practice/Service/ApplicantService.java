package data_jpa_tutorial.spring_data_jpa_practice.Service;

import data_jpa_tutorial.spring_data_jpa_practice.Entity.Applicant;
import data_jpa_tutorial.spring_data_jpa_practice.Repository.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    private ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository){
        this.applicantRepository = applicantRepository;
    }

    //get applicant
    public Optional<Applicant> getApplicant(Long id){
        return applicantRepository.findById(id);
    }

    //get all applicants
    public List<Applicant> getAllApplicants(){
        return applicantRepository.findAll();
    }

    //add applicant
    public Applicant addApplicant(Applicant applicant){
        return applicantRepository.save(applicant);
    }

    //delete applicant
    public void deleteApplicant(Long id){
        applicantRepository.deleteById(id);
    }
}
