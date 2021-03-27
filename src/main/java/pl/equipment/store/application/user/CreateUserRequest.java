package pl.equipment.store.application.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.equipment.store.domain.user.dto.CreateUserDto;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
class CreateUserRequest {
    @NotBlank(message = "Can't be blank!")
    private String username;

    @NotBlank(message = "Can't be blank!")
    private String password;

    static CreateUserDto toCreateUserDto(CreateUserRequest createUserRequest) {
        return new CreateUserDto(createUserRequest.getUsername(), createUserRequest.getPassword());
    }

}
