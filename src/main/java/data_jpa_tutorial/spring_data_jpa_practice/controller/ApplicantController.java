package data_jpa_tutorial.spring_data_jpa_practice.controller;

import data_jpa_tutorial.spring_data_jpa_practice.Entity.Applicant;
import data_jpa_tutorial.spring_data_jpa_practice.Service.ApplicantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/applicant")
public class ApplicantController {

    private ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService){
        this.applicantService = applicantService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Applicant> getApplicant(@PathVariable Long id){
        applicantService.getApplicant(id).orElse(null);
        return (ResponseEntity<Applicant>) ResponseEntity.ok();
    }

    @PostMapping("/add")
    public ResponseEntity<Applicant> addApplicant(@RequestBody Applicant applicant){
        applicantService.addApplicant(applicant);
        return ResponseEntity.status(201).body(applicant);
    }

}
