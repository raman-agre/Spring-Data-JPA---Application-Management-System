package data_jpa_tutorial.spring_data_jpa_practice.Repository;

import data_jpa_tutorial.spring_data_jpa_practice.Entity.Applicant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicationPagingAndSortingRepository extends ListPagingAndSortingRepository<Applicant, Long>, ListCrudRepository<Applicant, Long> {
}
