package deddictionsystem2.service;

import deddictionsystem2.exception.PatientNotFoundException;
import deddictionsystem2.model.Patient;
import deddictionsystem2.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientImpl implements IPatientService{


    private IPatientRepository patientRepository;

    @Autowired
    public void setPatientRepository(IPatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void updatePatient(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(int patientId)  throws PatientNotFoundException {
        return patientRepository.findById(patientId).orElseThrow(()->{
            throw new PatientNotFoundException() ;
        });
    }
}
