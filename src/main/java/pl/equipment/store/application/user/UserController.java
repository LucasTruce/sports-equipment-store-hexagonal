package pl.equipment.store.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.equipment.store.domain.user.port.in.UserPort;
import pl.equipment.store.domain.user.port.shared.UserDto;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
class UserController {
    private final UserPort userPort;

    @PostMapping
    UserDto saveUser(@RequestBody CreateUserRequest createUserRequest){
        return userPort.createUser(CreateUserRequest.ControllerDtoFactory.getInstance().createUserDto(createUserRequest));
    }

}
