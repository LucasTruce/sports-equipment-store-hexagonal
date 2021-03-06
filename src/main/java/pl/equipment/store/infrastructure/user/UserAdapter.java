package pl.equipment.store.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.order.port.in.UserDatabase;
import pl.equipment.store.domain.user.dto.SaveUserDto;
import pl.equipment.store.domain.user.dto.UserResponseDto;
import pl.equipment.store.domain.user.port.in.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class UserAdapter implements UserRepository, UserDatabase {

    private final UserSpringRepository userSpringRepository;

    @Override
    public UserResponseDto save(SaveUserDto saveUserDto) {
        UserEntity userEntity = userSpringRepository.save(UserMapper.toEntity(saveUserDto));
        return UserMapper.toResponseDto(userEntity);
    }

    @Override
    public List<UserResponseDto> findAll() {
        return userSpringRepository.findAll()
                .stream()
                .map(UserMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long userId) {
        return userSpringRepository.existsById(userId);
    }
}
