package pl.equipment.store.infrastructure.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.user.UserFacadeImpl;
import pl.equipment.store.domain.user.port.out.UserFacade;
import pl.equipment.store.infrastructure.user.spring.UserAdapter;
import pl.equipment.store.infrastructure.user.spring.UserSpringRepository;

@Configuration
class UserConfig {

    @Bean
    UserFacade userRepository(UserSpringRepository userSpringRepository){
        return new UserFacadeImpl(new UserAdapter(userSpringRepository));
    }



}
