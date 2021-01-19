package pl.equipment.store.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.equipment.store.domain.user.port.out.UserFacade;
import pl.equipment.store.domain.user.port.shared.UserDto;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
class UserController {
    private final UserFacade userFacade;

    @PostMapping
    UserDto saveUser(@RequestBody CreateUserRequest createUserRequest){
        return userFacade.createUser(CreateUserRequest.ControllerDtoFactory.getInstance().createUserDto(createUserRequest));
    }

}
