package pl.equipment.store.infrastructure.user;

import pl.equipment.store.domain.order.port.in.UserDatabase;
import pl.equipment.store.domain.user.dto.SaveUserDto;
import pl.equipment.store.domain.user.dto.UserResponseDto;
import pl.equipment.store.domain.user.port.in.UserRepository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryUserRepository implements UserRepository, UserDatabase {

    ConcurrentHashMap<Long, UserEntity> hashMap = new ConcurrentHashMap<>();
    Long i = 1L;

    @Override
    public UserResponseDto save(SaveUserDto saveUserDto) {
        UserEntity entity = UserMapper.toEntity(saveUserDto);
        entity.setId(i);
        hashMap.put(i++, entity);

        return UserMapper.toResponseDto(entity);
    }

    @Override
    public List<UserResponseDto> findAll() {
        return hashMap.values()
                .stream()
                .map(UserMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsById(Long userId) {
        return hashMap.containsKey(userId);
    }
}
