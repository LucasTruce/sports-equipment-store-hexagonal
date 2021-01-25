package pl.equipment.store.domain.user;

import lombok.Getter;
import pl.equipment.store.domain.user.port.in.UserCommandRepository;
import pl.equipment.store.domain.user.port.in.UserQueryRepository;
import pl.equipment.store.domain.user.port.out.UserCommand;
import pl.equipment.store.domain.user.port.out.UserQuery;

@Getter
public class UserFacade {

    private final UserCommand userCommand;
    private final UserQuery userQuery;

    public UserFacade(UserCommandRepository userCommandRepository, UserQueryRepository userQueryRepository) {
        this.userCommand = new UserCommandImpl(userCommandRepository);
        this.userQuery = new UserQueryImpl(userQueryRepository);
    }
}
