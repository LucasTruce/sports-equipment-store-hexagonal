package pl.equipment.store.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.user.dto.UserResponseDto;
import pl.equipment.store.domain.user.port.out.UserCommand;
import pl.equipment.store.domain.user.port.out.UserQuery;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "users")
@RequiredArgsConstructor
class UserController {

    private final UserCommand userCommand;
    private final UserQuery userQuery;

    @PostMapping
    UserResponseDto saveUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return userCommand.createUser(CreateUserRequest.toCreateUserDto(createUserRequest));
    }

    @GetMapping
    List<UserResponseDto> getAllUsers() {
        return userQuery.findAllUsers();
    }

}
