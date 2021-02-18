package pl.equipment.store.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.user.dto.SaveUserDto;
import pl.equipment.store.domain.user.dto.UserIdentificationDto;
import pl.equipment.store.domain.user.port.in.UserCommandRepository;
import pl.equipment.store.domain.user.port.in.UserQueryRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class UserAdapter implements UserCommandRepository, UserQueryRepository {

    private final UserSpringRepository userSpringRepository;

    @Override
    public UserIdentificationDto saveUser(SaveUserDto saveUserDto) {
        UserEntity userEntity = userSpringRepository.save(UserEntity.EntityFactory.toUserEntity(saveUserDto));
        return UserEntity.EntityFactory.toUserIdentificationDto(userEntity);
    }

    @Override
    public List<UserIdentificationDto> findAll() {
        List<UserEntity> list = userSpringRepository.findAll();
        return list.stream()
                .map(UserEntity.EntityFactory::toUserIdentificationDto)
                .collect(Collectors.toList());
    }
}
