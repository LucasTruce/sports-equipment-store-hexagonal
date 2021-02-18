package pl.equipment.store.domain.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.user.port.in.UserCommandRepository;
import pl.equipment.store.domain.user.port.in.UserQueryRepository;

@Configuration
class UserDomainConfig {

    @Bean
    UserFacade userFacade(UserCommandRepository userCommandRepository, UserQueryRepository userQueryRepository){
        return new UserFacade(userCommandRepository, userQueryRepository);
    }
}
