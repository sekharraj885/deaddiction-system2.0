//package deddictionsystem2.model;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//@Entity
//@Setter
//@Getter
//@ToString
//public class MedicationList {
//
//    @Id
//    @GeneratedValue(generator = "medicationlist_seq",strategy = GenerationType.AUTO )
//    @SequenceGenerator(name="medicationlist_seq",sequenceName = "medicationlist_seq",initialValue = 1,allocationSize = 1)
//    @Column(name = "medicationlistid")
//    private Integer medicationListId;
//
//    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
//    private Set<Medicine> medicines;
//
//
//
//    public MedicationList() {
//    }
//
////    public MedicationList(Set<Medicine> medicines) {
////        this.medicines = medicines;
////    }
//
//
//    public MedicationList(Set<Medicine> medicines) {
//        this.medicines = medicines;
//    }
//}
