package pl.equipment.store.domain.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.user.port.in.UserRepository;

@Configuration
class UserDomainConfig {

    @Bean
    UserCommandFacade userCommandFacade(UserRepository userRepository){
        return new UserCommandFacade(userRepository);
    }

    @Bean
    UserQueryFacade userQueryFacade(UserRepository userRepository){
        return new UserQueryFacade(userRepository);
    }
}
