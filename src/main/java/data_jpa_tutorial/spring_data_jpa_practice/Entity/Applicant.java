package data_jpa_tutorial.spring_data_jpa_practice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "APPLICANT")
@Data
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "status")
    private String status;
}
