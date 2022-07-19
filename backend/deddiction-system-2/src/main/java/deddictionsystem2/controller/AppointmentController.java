package deddictionsystem2.controller;

import deddictionsystem2.model.AppointmentLog;
import deddictionsystem2.model.Patient;
import deddictionsystem2.repository.IAppointmentRepository;
import deddictionsystem2.service.IAppointmentService;
import deddictionsystem2.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/appointment-api")
public class AppointmentController {

    private IAppointmentService appointmentService;

    @Autowired
    public void setAppointmentService(IAppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    private IAppointmentRepository appointmentRepository;

    @Autowired
    public void setAppointmentRepository(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    private IPatientService patientService;

    @Autowired
    public AppointmentController(IPatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/appointment")
    public ResponseEntity<AppointmentLog>addAppointment(@RequestBody AppointmentLog appointmentLog){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding an appointment");
        AppointmentLog appointmentLog1 =appointmentService.addAppointment(appointmentLog);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(appointmentLog1);
    }

    @PutMapping("/update/appointment")
    public ResponseEntity<Void>updateAppointment(@RequestBody AppointmentLog appointmentLog){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating an appointment");
        appointmentService.updateAppointment(appointmentLog);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

//    @PatchMapping("/patch/appointment/id/{appointmentLogId}")
//    public ResponseEntity<Void>patchAppointment( @RequestBody AppointmentLog appointmentLog,@PathVariable("appointmentLogId") int appointmentLogId){
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("desc", "updating an appointment");
//        appointmentService.patchAppointment(appointmentLog, appointmentLogId);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
//    }

    @PatchMapping("/patch/appointment/id/{appointmentLogId}")
    public ResponseEntity<Void>patchAppointment( @RequestBody AppointmentLog appointmentLog,@PathVariable("appointmentLogId") int appointmentLogId){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating an appointment");
        AppointmentLog appointmentLog1=appointmentRepository.findById(appointmentLogId).get();
        appointmentLog1.setCheckOut(appointmentLog.getCheckOut());
        appointmentLog1.setNextFollowup(appointmentLog.getNextFollowup());
        appointmentLog1.setFollowupInfo(appointmentLog.getFollowupInfo());
        appointmentLog1.setMedication(appointmentLog.getMedication());
        appointmentService.patchAppointment(appointmentLog1);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }



    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentLog>>getAppointments(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all appointments");
        List<AppointmentLog>appointmentLogs=appointmentService.getAllAppointments();
        ResponseEntity<List<AppointmentLog>> appointmentResponse = new ResponseEntity(appointmentLogs,headers,HttpStatus.OK);
        return appointmentResponse;
    }

//    @GetMapping("/appointments/followup/{nextFollowup}")
//    public ResponseEntity<List<AppointmentLog>>getAppointmentsByFollowupDate(@PathVariable("nextFollowup") String checkIn){
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("desc", "Getting Appointments by followup date");
//        List<AppointmentLog>appointmentLogs =appointmentService.getAppointmentsByFollowUp(checkIn);
//        ResponseEntity<List<AppointmentLog>>AppointmentResponse = new ResponseEntity<>(appointmentLogs,headers,HttpStatus.OK);
//        return AppointmentResponse;
//    }

    @GetMapping("/appointment/id/{appointmentId}")
    ResponseEntity<AppointmentLog> getAppointmentById(@PathVariable("appointmentId") int appointmentId) {
        HttpHeaders headers = new HttpHeaders();
        AppointmentLog appointment = appointmentService.getAppointmentById(appointmentId);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(appointment);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>>getAllPatients(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting all patients");
        List<Patient>patients=patientService.getAllPatients();
        ResponseEntity<List<Patient>> patientResponse = new ResponseEntity(patients,headers,HttpStatus.OK);
        return patientResponse;
    }

    @PostMapping("/patient")
    public ResponseEntity<Patient>addPatient(@RequestBody Patient patient){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Adding an appointment");
        Patient patient1 =patientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(patient1);
    }

    @GetMapping("/patient/id/{patientId}")
    ResponseEntity<Patient> getPatientById(@PathVariable("patientId") int patientId) {
        HttpHeaders headers = new HttpHeaders();
        Patient patient = patientService.getPatientById(patientId);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(patient);
    }

    }


