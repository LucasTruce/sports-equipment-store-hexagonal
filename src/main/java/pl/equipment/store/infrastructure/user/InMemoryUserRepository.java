package pl.equipment.store.infrastructure.user;

import pl.equipment.store.domain.user.dto.SaveUserDto;
import pl.equipment.store.domain.user.dto.UserResponseDto;
import pl.equipment.store.domain.user.port.in.UserRepository;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryUserRepository implements UserRepository {

    ConcurrentHashMap<Long, UserEntity> hashMap = new ConcurrentHashMap<>();

    @Override
    public UserResponseDto save(SaveUserDto saveUserDto) {
        UserEntity userEntity = UserMapper.toEntity(saveUserDto);
        hashMap.put(new Random().nextLong(), userEntity);
        return UserMapper.toResponseDto(userEntity);
    }

    @Override
    public List<UserResponseDto> findAll() {
        return hashMap.values()
                .stream()
                .map(UserMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
