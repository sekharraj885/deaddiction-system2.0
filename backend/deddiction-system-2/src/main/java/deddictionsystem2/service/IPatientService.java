package deddictionsystem2.service;

import deddictionsystem2.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPatientService {

    Patient addPatient(Patient patient);

    List<Patient>getAllPatients();

    void updatePatient(Patient patient);

    Patient getPatientById(int patientId);

}
