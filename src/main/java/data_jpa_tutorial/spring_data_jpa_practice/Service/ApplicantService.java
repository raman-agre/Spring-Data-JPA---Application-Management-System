package data_jpa_tutorial.spring_data_jpa_practice.Service;

import data_jpa_tutorial.spring_data_jpa_practice.Entity.Applicant;
import data_jpa_tutorial.spring_data_jpa_practice.Repository.ApplicantRepository;
import data_jpa_tutorial.spring_data_jpa_practice.Repository.ApplicationPagingAndSortingRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    private ApplicantRepository applicantRepository;

    private ApplicationPagingAndSortingRepository applicationPagingAndSortingRepository;

    public ApplicantService(ApplicantRepository applicantRepository, ApplicationPagingAndSortingRepository applicationPagingAndSortingRepository){
        this.applicantRepository = applicantRepository;
        this.applicationPagingAndSortingRepository = applicationPagingAndSortingRepository;
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

    //pagination
    public Iterable<Applicant> getApplicantWithPagination(int page, int size){
        return applicationPagingAndSortingRepository.findAll(PageRequest.of(page, size));
    }

    //query methods
    public List<Applicant> findByStatus(String status){
         return applicantRepository.findByStatus(status);
    }

    //query annotation
    public List<Applicant> findByPartialName(String name){
        return applicantRepository.findApplicantsByPartialName(name);
    }

    public Applicant findByPhone(String phone){
        return applicantRepository.findByPhone(phone);
    }
}
