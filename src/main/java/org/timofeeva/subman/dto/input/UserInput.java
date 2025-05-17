package org.timofeeva.subman.dto.input;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.timofeeva.subman.domain.User;
import org.timofeeva.subman.validation.annotation.UniqueValue;

import java.time.LocalDate;

@Data
public class UserInput {

    @UniqueValue(
            message = "Пользователь с таким логином уже существует",
            referenceClass = User.class,
            referenceField = "login"
    )
    @NotEmpty(message = "Поле login обязательно для заполнения")
    private String login;

    @NotEmpty(message = "Поле fullName обязательно для заполнения")
    private String fullName;

    @NotNull(message = "Поле birthDate обязательно для заполнения")
    private LocalDate birthDate;

    private String phone;

    private String email;

}
