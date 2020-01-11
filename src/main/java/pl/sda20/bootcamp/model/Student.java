//package pl.sda20.bootcamp.model;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.validator.constraints.UniqueElements;
//
//import javax.persistence.*;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Student {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @NotEmpty(message = "Podaj imię!") // 1 sposob wpisujac tutaj komunikat
//    private String firstName;
//    @NotEmpty(message = "{lastName.NotEmpty}") // 2 sposob to przywolanie z pliku stworzonego do bledow
//    private String lastName;
//    @Email
//    @NotEmpty
//    @Column(unique = true, length = 255)
//    private String email;
//    @NotEmpty
//    private String phone;
//    @NotEmpty
//    private String courseName;
//    @NotEmpty
//    private String mode;
//
//
//}
