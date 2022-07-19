package deddictionsystem2.repository;

import deddictionsystem2.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer> {


}
