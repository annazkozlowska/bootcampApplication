package pl.sda20.bootcamp.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    @NotEmpty(message = "{firstName.NotEmpty}")
    private String firstName;
    @NotEmpty(message = "{lastName.NotEmpty}")
    private String lastName;
    @Email
    @NotEmpty(message = "{mail.NotEmpty}")
    @Column(unique = true)
    private String mail;
    @NotEmpty(message = "{phone.NotEmpty}")
    private String phone;
    private String mode;
    @NotEmpty(message = "{password.NotEmpty}")
    private String password;
    private int salary;
    @ElementCollection
    private List<String> courses;
    @ManyToOne
    @JoinColumn(name = "role_id") //????????????????
    private Role role;
}
