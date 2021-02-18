package pl.equipment.store.application.user;

import lombok.Getter;
import pl.equipment.store.domain.user.dto.CreateUserDto;

@Getter
class CreateUserRequest {
    private String username;
    private String password;

    static CreateUserDto toCreateUserDto(CreateUserRequest createUserRequest){
        return new CreateUserDto(createUserRequest.getUsername(), createUserRequest.getPassword());
    }

}
