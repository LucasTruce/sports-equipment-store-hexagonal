package pl.equipment.store.infrastructure.user.spring;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.port.in.UserRepository;
import pl.equipment.store.domain.user.port.shared.UserDto;

@RequiredArgsConstructor
public class UserAdapter implements UserRepository {

    private final UserSpringRepository userSpringRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {
        UserEntity userEntity = userSpringRepository.save(UserEntity.EntityFactory.getInstance().toUserEntity(userDto));
        return UserEntity.EntityFactory.getInstance().toUserDto(userEntity);
    }
}
