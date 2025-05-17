package org.timofeeva.subman.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserOutput {

    private Long id;

    private String login;

    private String fullName;

    private LocalDate birthDate;

    private String phone;

    private String email;

}
