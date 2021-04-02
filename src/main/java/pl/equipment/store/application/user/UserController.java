package pl.equipment.store.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.user.dto.UserResponseDto;
import pl.equipment.store.domain.user.port.out.CreateUser;
import pl.equipment.store.domain.user.port.out.FindUser;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "users")
@RequiredArgsConstructor
class UserController {

    private final CreateUser createUser;
    private final FindUser findUser;

    @PostMapping
    UserResponseDto saveUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return createUser.create(CreateUserRequest.toCreateUserDto(createUserRequest));
    }

    @GetMapping
    List<UserResponseDto> getAllUsers() {
        return findUser.findAll();
    }
}
