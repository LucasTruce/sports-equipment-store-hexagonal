package pl.equipment.store.infrastructure.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.order.port.in.UserDatabase;
import pl.equipment.store.domain.user.dto.SaveUserDto;
import pl.equipment.store.domain.user.dto.UserResponseDto;
import pl.equipment.store.domain.user.port.in.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class UserAdapter implements UserRepository, UserDatabase, UserDetailsService {

    private final UserSpringRepository userSpringRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserResponseDto save(SaveUserDto saveUserDto) {
        UserEntity userEntity = UserMapper.toEntity(saveUserDto);
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userSpringRepository.save(userEntity);
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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userSpringRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
    }
}
