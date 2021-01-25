package pl.equipment.store.infrastructure.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.user.UserFacade;
import pl.equipment.store.domain.user.port.in.UserCommandRepository;
import pl.equipment.store.domain.user.port.in.UserQueryRepository;
import pl.equipment.store.infrastructure.user.spring.UserAdapter;
import pl.equipment.store.infrastructure.user.spring.UserSpringRepository;

@Configuration
class UserConfig {

    @Bean
    UserFacade userFacade(UserCommandRepository userCommandRepository, UserQueryRepository userQueryRepository){
        return new UserFacade(userCommandRepository, userQueryRepository);
    }

    @Bean
    UserCommandRepository userCommandRepository(UserSpringRepository userSpringRepository){
        return new UserAdapter(userSpringRepository);
    }

    @Bean
    UserQueryRepository userQueryRepository(UserSpringRepository userSpringRepository){
        return new UserAdapter(userSpringRepository);
    }



}
