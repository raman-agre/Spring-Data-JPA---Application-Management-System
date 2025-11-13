package data_jpa_tutorial.spring_data_jpa_practice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "APPLICANT", schema = "BUSINESS_DATA")
@Data
public class Applicant {

//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
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
