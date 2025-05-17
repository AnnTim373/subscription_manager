package org.timofeeva.subman.web.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.timofeeva.subman.dto.input.UserInput;
import org.timofeeva.subman.dto.output.UserOutput;
import org.timofeeva.subman.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserOutput> createUser(@Valid @RequestBody UserInput user) {
        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserOutput> updateUser(@PathVariable Long id,@Valid @RequestBody UserInput user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserOutput> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
