package pl.equipment.store.infrastructure.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.user.UserFacade;
import pl.equipment.store.domain.user.port.in.UserPort;
import pl.equipment.store.infrastructure.user.spring.UserAdapter;
import pl.equipment.store.infrastructure.user.spring.UserSpringRepository;

@Configuration
class UserConfig {

    @Bean
    UserPort userRepository(UserSpringRepository userSpringRepository){
        return new UserFacade(new UserAdapter(userSpringRepository));
    }

}
