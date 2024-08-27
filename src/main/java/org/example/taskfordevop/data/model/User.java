package org.example.taskfordevop.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.taskfordevop.data.constant.Gender;
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Column(unique = true)
    private String email;
    private String password;
    private Gender gender;
}
