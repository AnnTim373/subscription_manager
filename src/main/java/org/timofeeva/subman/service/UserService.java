package org.timofeeva.subman.service;

import org.timofeeva.subman.dto.input.UserInput;
import org.timofeeva.subman.dto.output.UserOutput;

public interface UserService {

    UserOutput createUser(UserInput userInput);

    UserOutput updateUser(Long id, UserInput userInput);

    UserOutput getUser(Long id);

    void deleteUser(Long id);

}
