package pl.equipment.store.application.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.equipment.store.domain.user.dto.CreateUserDto;

import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
class CreateUserRequest {
    @NotBlank(message = "Can't be blank!")
    private final String username;

    @NotBlank(message = "Can't be blank!")
    private final String password;

    static CreateUserDto toCreateUserDto(CreateUserRequest createUserRequest){
        return new CreateUserDto(createUserRequest.getUsername(), createUserRequest.getPassword());
    }

}
