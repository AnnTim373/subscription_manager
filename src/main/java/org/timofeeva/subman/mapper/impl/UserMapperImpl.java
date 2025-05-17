package org.timofeeva.subman.mapper.impl;

import org.springframework.stereotype.Component;
import org.timofeeva.subman.domain.User;
import org.timofeeva.subman.dto.input.UserInput;
import org.timofeeva.subman.dto.output.UserOutput;
import org.timofeeva.subman.mapper.UserMapper;

@Component
class UserMapperImpl implements UserMapper {

    @Override
    public User fromInputDTO(UserInput userInput) {
        return User.builder()
                .login(userInput.getLogin())
                .fullName(userInput.getFullName())
                .birthDate(userInput.getBirthDate())
                .phone(userInput.getPhone())
                .email(userInput.getEmail())
                .build();
    }

    @Override
    public UserOutput toOutputDTO(User user) {
        return UserOutput.builder()
                .id(user.getId())
                .login(user.getLogin())
                .fullName(user.getFullName())
                .birthDate(user.getBirthDate())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }

}
