package data_jpa_tutorial.spring_data_jpa_practice.Repository;

import data_jpa_tutorial.spring_data_jpa_practice.Entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

}
