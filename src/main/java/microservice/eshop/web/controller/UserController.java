package microservice.eshop.web.controller;

import microservice.eshop.service.api.UserService;
import microservice.eshop.web.model.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(userService.getById(userId), HttpStatus.OK);
    }

    @PostMapping(path = "user")
    public ResponseEntity<UserDto> saveNewProduct(@RequestBody @Validated UserDto userDto) {
        return ResponseEntity.ok(userService.saveNewUser(userDto));
    }

    @DeleteMapping("user/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("userId") Long userId) {

        userService.deleteUserById(userId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("user/{userId}")
    public ResponseEntity updateUserById(@PathVariable("userId") Long userId, @RequestBody @Validated UserDto userDto) {
        return new ResponseEntity<>(userService.updateUser(userId, userDto), HttpStatus.NO_CONTENT);
    }
}
