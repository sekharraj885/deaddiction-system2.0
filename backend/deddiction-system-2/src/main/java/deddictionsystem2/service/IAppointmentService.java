package deddictionsystem2.service;

import deddictionsystem2.model.AppointmentLog;
import deddictionsystem2.model.Patient;

import java.util.List;

public interface IAppointmentService {

    AppointmentLog addAppointment(AppointmentLog appointmentLog);

    List<AppointmentLog> getAllAppointments();

    AppointmentLog getAppointmentById(int appointmentLogId);

    void updateAppointment(AppointmentLog appointmentLog);

    void patchAppointment(AppointmentLog appointmentLog);

//    List<AppointmentLog> getAppointmentsByFollowUp(String checkIn);

//    List<AppointmentLog> getAppointmentsByPatientId(int patientId);






}
