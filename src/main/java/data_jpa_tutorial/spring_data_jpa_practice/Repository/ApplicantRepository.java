package data_jpa_tutorial.spring_data_jpa_practice.Repository;

import data_jpa_tutorial.spring_data_jpa_practice.Entity.Applicant;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    List<Applicant> findByStatus(String status);

    @Query("SELECT a FROM Applicant a WHERE a.name LIKE %:name%")
    List<Applicant> findApplicantsByPartialName(@Param("name") String name);

    @Query("SELECT a FROM Applicant a WHERE phone = :phone")
    Applicant findByPhone(@Param("phone") String phone);
}
