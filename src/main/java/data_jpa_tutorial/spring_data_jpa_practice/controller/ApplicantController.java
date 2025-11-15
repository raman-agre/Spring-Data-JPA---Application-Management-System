package data_jpa_tutorial.spring_data_jpa_practice.controller;

import data_jpa_tutorial.spring_data_jpa_practice.Entity.Applicant;
import data_jpa_tutorial.spring_data_jpa_practice.Service.ApplicantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {

    private ApplicantService applicantService;

    public ApplicantController(ApplicantService applicantService){
        this.applicantService = applicantService;
    }

     @GetMapping("/get/{id}")
    public ResponseEntity<Applicant> getApplicant(@PathVariable Long id){
        Applicant applicant =  applicantService.getApplicant(id).orElse(null);
        return ResponseEntity.status(HttpStatus.OK).body(applicant);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Applicant>> getAllApplicant(){
        return ResponseEntity.status(HttpStatus.OK).body(applicantService.getAllApplicants());
    }

    @PostMapping("/add")
    public ResponseEntity<Applicant> addApplicant(@RequestBody Applicant applicant){
        applicantService.addApplicant(applicant);
        return ResponseEntity.ok(applicant);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteApplicant(@PathVariable Long id){
        applicantService.deleteApplicant(id);
        return ResponseEntity.ok().body("Applicant deleted");
    }

    @GetMapping("/page")
    public Iterable<Applicant> getApplicantWithPagination(@RequestParam int page, @RequestParam int size){
        return applicantService.getApplicantWithPagination(page, size);
    }

    @GetMapping("/getByStatus")
    public List<Applicant> findByStatus(@RequestParam String status){
        return applicantService.findByStatus(status);
    }

    @GetMapping("/getByName")
    public ResponseEntity<List<Applicant>> findApplicantByPartialName(@RequestParam String name){
        return ResponseEntity.ok(applicantService.findByPartialName(name));
    }

    @GetMapping("/phone")
    public ResponseEntity<Applicant> getByPhone(@RequestParam String phone){
        return ResponseEntity.ok(applicantService.findByPhone(phone));
    }

}
