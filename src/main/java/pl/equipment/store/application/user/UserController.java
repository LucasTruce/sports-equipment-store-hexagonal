package pl.equipment.store.application.user;

import org.springframework.web.bind.annotation.*;
import pl.equipment.store.domain.user.UserFacade;
import pl.equipment.store.domain.user.port.out.UserCommand;
import pl.equipment.store.domain.user.port.out.UserQuery;
import pl.equipment.store.domain.user.port.shared.UserDto;

import java.util.List;

@RestController
@RequestMapping("/users")
class UserController {

    private final UserCommand userCommand;
    private final UserQuery userQuery;

    public UserController(UserFacade userFacade) {
        this.userCommand = userFacade.getUserCommand();
        this.userQuery = userFacade.getUserQuery();
    }

    @PostMapping
    UserDto saveUser(@RequestBody CreateUserRequest createUserRequest){
        return userCommand.createUser(CreateUserRequest.createUserDto(createUserRequest));
    }

    @GetMapping
    List<UserDto> getAllUsers(){
        return userQuery.findAllUsers();
    }

}
