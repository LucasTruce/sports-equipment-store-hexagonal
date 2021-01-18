package pl.equipment.store.application.user;

import lombok.Getter;
import lombok.Setter;
import pl.equipment.store.domain.user.port.shared.UserDto;

@Getter
@Setter
class CreateUserRequest {
    private String username;
    private String password;


    static class ControllerDtoFactory {
        @Getter
        private static final ControllerDtoFactory instance = new ControllerDtoFactory();
        UserDto createUserDto(CreateUserRequest createUserRequest){
            return new UserDto(0L, createUserRequest.getUsername(), createUserRequest.getPassword());
        }

    }

}
