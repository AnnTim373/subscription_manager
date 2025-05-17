package org.timofeeva.subman.mapper;

import org.timofeeva.subman.domain.User;
import org.timofeeva.subman.dto.input.UserInput;
import org.timofeeva.subman.dto.output.UserOutput;

public interface UserMapper {

    User fromInputDTO(UserInput userInput);

    UserOutput toOutputDTO(User user);

}
