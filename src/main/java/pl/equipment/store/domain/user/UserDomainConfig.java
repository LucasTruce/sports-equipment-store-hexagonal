package pl.equipment.store.domain.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.user.port.in.UserRepository;

@Configuration
class UserDomainConfig {

    @Bean
    UserFacade userCommandFacade(UserRepository userRepository) {
        UserService userService = new UserService(userRepository);
        return new UserFacade(userService);
    }


}
