package pl.equipment.store.application.user;

import lombok.Getter;
import pl.equipment.store.domain.user.port.shared.CreateUserDto;

@Getter
class CreateUserRequest {
    private String username;
    private String password;

    static CreateUserDto createUserDto(CreateUserRequest createUserRequest){
        return new CreateUserDto(createUserRequest.getUsername(), createUserRequest.getPassword());
    }

}
