//package deddictionsystem2.model;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//
//@Entity
//@Setter
//@Getter
//@ToString
//public class Medicine {
//
//    @Id
//    @GeneratedValue(generator = "medicine_seq",strategy = GenerationType.AUTO )
//    @SequenceGenerator(name="medicine_seq",sequenceName = "medicine_seq",initialValue = 1,allocationSize = 1)
//    @Column(name = "medicineid")
//    private Integer medicineId ;
//
//
//    private String medicineName;
//
//
//
//    public Medicine() {
//    }
//
//    public Medicine(String medicineName) {
//        this.medicineName = medicineName;
//    }
//}
