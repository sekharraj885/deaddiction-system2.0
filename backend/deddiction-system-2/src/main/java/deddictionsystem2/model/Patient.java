package deddictionsystem2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
public class Patient {

    @Id
    @GeneratedValue(generator = "patient_seq",strategy = GenerationType.AUTO )
    @SequenceGenerator(name="patient_seq",sequenceName = "patient_seq",initialValue = 100,allocationSize = 1)
    @Column(name = "patientid")
    private Integer patientId;

    private String patientName;

    private Integer age;

    private Gender gender;

    private  String mail;

    private String contactNumber;

    private Addictiontype addictiontype;


    //@OneToMany(fetch = FetchType.EAGER)
//
    //private Set<AppointmentLog> appointmentLogs;


    public Patient() {
    }

    public Patient(String patientName, Integer age, Gender gender, String mail, String contactNumber, Addictiontype addictiontype) {
        this.patientName = patientName;
        this.age = age;
        this.gender = gender;
        this.mail = mail;
        this.contactNumber = contactNumber;
        this.addictiontype = addictiontype;
    }
}
