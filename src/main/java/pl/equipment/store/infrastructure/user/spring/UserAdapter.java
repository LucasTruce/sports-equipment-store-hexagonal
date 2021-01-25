package pl.equipment.store.infrastructure.user.spring;

import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.port.in.UserCommandRepository;
import pl.equipment.store.domain.user.port.in.UserQueryRepository;
import pl.equipment.store.domain.user.port.shared.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserAdapter implements UserCommandRepository, UserQueryRepository {

    private final UserSpringRepository userSpringRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {
        UserEntity userEntity = userSpringRepository.save(UserEntity.EntityFactory.getInstance().toUserEntity(userDto));
        return UserEntity.EntityFactory.getInstance().toUserDto(userEntity);
    }

    @Override
    public List<UserDto> findAll() {
        List<UserEntity> list = userSpringRepository.findAll();
        return list.stream()
                .map(u -> UserEntity.EntityFactory.getInstance().toUserDto(u))
                .collect(Collectors.toList());
    }
}
