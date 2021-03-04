package pl.equipment.store.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.user.dto.SaveUserDto;
import pl.equipment.store.domain.user.dto.UserResponseDto;
import pl.equipment.store.domain.user.port.in.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class UserAdapter implements UserRepository {

    private final UserSpringRepository userSpringRepository;

    @Override
    public UserResponseDto saveUser(SaveUserDto saveUserDto) {
        UserEntity userEntity = userSpringRepository.save(UserEntity.toUserEntity(saveUserDto));
        return UserEntity.toUserIdentificationDto(userEntity);
    }

    @Override
    public List<UserResponseDto> findAll() {
        List<UserEntity> list = userSpringRepository.findAll();
        return list.stream()
                .map(UserEntity::toUserIdentificationDto)
                .collect(Collectors.toList());
    }
}
