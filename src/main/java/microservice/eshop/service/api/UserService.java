package microservice.eshop.service.api;

import microservice.eshop.web.model.UserDto;

public interface UserService {
    UserDto getById(Long id);

    void deleteUserById(Long userId);

    UserDto saveNewUser(UserDto userDto);

    UserDto updateUser(Long userId, UserDto userDto);
}
