package deddictionsystem2;

import deddictionsystem2.model.*;
import deddictionsystem2.service.IAppointmentService;
import deddictionsystem2.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class DeddictionSystem2Application implements CommandLineRunner {

	private Object Medicine;

	public static void main(String[] args) {
		SpringApplication.run(DeddictionSystem2Application.class, args);
	}

	@Autowired private IAppointmentService appointmentService;

	private IPatientService patientService;

//	@Autowired private IAppointmentService appointmentService;




	@Override
	public void run(String... args) throws Exception {

		Patient patient = new Patient("Francis",32, Gender.MALE,"Francis009@gmail.com","8965741236", Addictiontype.ALCOHOL);

		AppointmentLog appointmentLog=new AppointmentLog(patient,null,null,null,null,"Dolozo 950");

//		appointmentService.addAppointment(appointmentLog);

//		System.out.println(patientService.getPatientById(100));
//		System.out.println(appointmentService.getAppointmentById(10000));
//		System.out.println("1231231213 ->->"+appointmentService.getAppointmentsByPatientId(100));


	}
}
