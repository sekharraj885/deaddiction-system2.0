package deddictionsystem2.repository;

import deddictionsystem2.model.AppointmentLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAppointmentRepository extends JpaRepository<AppointmentLog, Integer> {

//    @Query("from appointmentlog a where a.checkin LIKE %?1%")
//    List<AppointmentLog>findAppointmentByFollowup(String checkIn);

//    @Query("from appointmentlog a where a.patientid =  ?1")
//    List<AppointmentLog>findAppointmentsByPatientId(int patientId);
}
