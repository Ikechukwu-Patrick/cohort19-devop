package org.example.taskfordevop.dtos.requests;

import jakarta.persistence.Column;
import lombok.*;
import org.example.taskfordevop.data.constant.Gender;
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequests {

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String phoneNumber;
    private Gender gender;
}
