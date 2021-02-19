package pl.equipment.store.domain.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.user.port.in.UserCommandRepository;
import pl.equipment.store.domain.user.port.in.UserQueryRepository;

@Configuration
class UserDomainConfig {

    @Bean
    UserCommandFacade userCommandFacade(UserCommandRepository userCommandRepository){
        return new UserCommandFacade(userCommandRepository);
    }

    @Bean
    UserQueryFacade userQueryFacade(UserQueryRepository userQueryRepository){
        return new UserQueryFacade(userQueryRepository);
    }
}
