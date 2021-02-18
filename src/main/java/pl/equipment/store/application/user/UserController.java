package pl.equipment.store.application.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.user.dto.UserIdentificationDto;
import pl.equipment.store.domain.user.port.out.UserCommand;
import pl.equipment.store.domain.user.port.out.UserQuery;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
class UserController {

    private final UserCommand userCommand;
    private final UserQuery userQuery;

    @PostMapping
    UserIdentificationDto saveUser(@RequestBody CreateUserRequest createUserRequest){
        return userCommand.createUser(CreateUserRequest.toCreateUserDto(createUserRequest));
    }

    @GetMapping
    List<UserIdentificationDto> getAllUsers(){
        return userQuery.findAllUsers();
    }

}
