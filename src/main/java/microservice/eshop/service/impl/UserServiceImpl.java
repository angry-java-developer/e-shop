package microservice.eshop.service.impl;

import microservice.eshop.domain.User;
import microservice.eshop.repository.UserRepository;
import microservice.eshop.service.api.UserService;
import microservice.eshop.web.mapper.UserMapper;
import microservice.eshop.web.model.UserDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto getById(Long id) {
        return userMapper.map(userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product doesn't exist!")));
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDto saveNewUser(UserDto userDto) {
        return userMapper.map(userRepository.save(userMapper.mapToDto(userDto)));
    }

    @Override
    @Transactional
    public UserDto updateUser(Long userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Product doesn't exist!"));

        user.setUsername(userDto.getUsername());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());

        return userMapper.map(userRepository.save(user));
    }
}
