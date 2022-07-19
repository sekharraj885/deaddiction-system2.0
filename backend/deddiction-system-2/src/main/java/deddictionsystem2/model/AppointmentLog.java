package deddictionsystem2.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity(name = "appointmentlog")
@Setter
@Getter
@ToString
public class AppointmentLog {
    @Id
    @GeneratedValue(generator = "appointment_seq",strategy = GenerationType.AUTO )
    @SequenceGenerator(name="appointment_seq",sequenceName = "appointment_seq",initialValue = 10000,allocationSize = 1)
    @Column(name = "appointmentlogid")

    private Integer appointmentLogId;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "patientid")
//    @JsonIgnore
    private Patient patient;

    @Column(name ="checkin" )

    private String checkIn;

    @Column(name ="checkout" )
    private String checkOut;

    @Column(name = "nextfollowup")
    private String nextFollowup;

    private String followupInfo;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="medicationListId")
//    private MedicationList medicationList;

//    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
//    private Medicine medicine;

    private String medication;

    public AppointmentLog() {
    }

//    public AppointmentLog(Patient patient, String checkIn, String checkOut, String nextFollowup, String followupInfo, MedicationList medicationList) {
//        this.patient = patient;
//        this.checkIn = checkIn;
//        this.checkOut = checkOut;
//        this.nextFollowup = nextFollowup;
//        this.followupInfo = followupInfo;
//        this.medicationList = medicationList;
//    }


    public AppointmentLog(Patient patient, String checkIn, String checkOut, String nextFollowup, String followupInfo, String medication) {
        this.patient = patient;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.nextFollowup = nextFollowup;
        this.followupInfo = followupInfo;
        this.medication = medication;
    }
}
