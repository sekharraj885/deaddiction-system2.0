package deddictionsystem2.service;

import deddictionsystem2.exception.AppointmentNotFound;
import deddictionsystem2.model.AppointmentLog;
import deddictionsystem2.model.Patient;
import deddictionsystem2.repository.IAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentImpl implements IAppointmentService{

    private IAppointmentRepository appointmentRepository;

    @Autowired
    private PatientImpl patientImpl;


    @Autowired
    public void setAppointmentRepository(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentLog addAppointment(AppointmentLog appointmentLog) {
        Patient p1 = patientImpl.getPatientById(appointmentLog.getPatient().getPatientId());
        AppointmentLog app = new AppointmentLog(p1,null,null,null,null,null);
        return appointmentRepository.save(app);
    }

    @Override
    public void updateAppointment(AppointmentLog appointmentLog) {
         appointmentRepository.save(appointmentLog);
    }

    @Override
    public void patchAppointment(AppointmentLog appointmentLog ) {
//        AppointmentLog app = appointmentImpl.getAppointmentById(appointmentLogId);
        appointmentRepository.save(appointmentLog);
    }


//    @Override
//    public List<AppointmentLog> getAppointmentsByFollowUp(String checkIn) {
//        return appointmentRepository.findAppointmentByFollowup(checkIn);
//    }

    @Override
    public List<AppointmentLog> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public AppointmentLog getAppointmentById(int appointmentLogId) {
        return appointmentRepository.findById(appointmentLogId).orElseThrow(()->{
            throw new AppointmentNotFound();
        });
    }

//    @Override
//    public List<AppointmentLog> getAppointmentsByFollowUp(String checkIn) {
//        return appointmentRepository.findAppointmentByFollowup(checkIn);
//    }


//    @Override
//    public List<AppointmentLog> getAppointmentsByPatientId(int patientId) {
//        return appointmentRepository.findAppointmentsByPatientId(patientId);
//    }




}
