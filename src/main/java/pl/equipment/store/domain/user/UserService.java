package pl.equipment.store.domain.user;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.dto.CreateUserDto;
import pl.equipment.store.domain.user.dto.UserResponseDto;
import pl.equipment.store.domain.user.port.in.UserRepository;

import java.util.List;

@RequiredArgsConstructor
class UserService {
    private final UserRepository userRepository;

    public UserResponseDto save(CreateUserDto createUserDto) {
        return userRepository.save(User.create(createUserDto));
    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll();
    }
}
