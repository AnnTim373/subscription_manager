package org.timofeeva.subman.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.timofeeva.subman.domain.User;
import org.timofeeva.subman.dto.input.UserInput;
import org.timofeeva.subman.dto.output.UserOutput;
import org.timofeeva.subman.error.custom_exception.UserNotFoundException;
import org.timofeeva.subman.mapper.UserMapper;
import org.timofeeva.subman.repository.UserRepository;
import org.timofeeva.subman.service.UserService;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserOutput createUser(UserInput userInput) {
        log.info("Creating user {}", userInput);
        return userMapper.toOutputDTO(userRepository.save(userMapper.fromInputDTO(userInput)));
    }

    @Override
    public UserOutput updateUser(Long id, UserInput userInput) {
        log.info("Updating user {}: {}", id, userInput);
        User user = userMapper.fromInputDTO(userInput);
        user.setId(id);
        return userMapper.toOutputDTO(userRepository.save(user));
    }

    @Override
    public UserOutput getUser(Long id) {
        return userMapper.toOutputDTO(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Deleting user {}", id);
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }

}
