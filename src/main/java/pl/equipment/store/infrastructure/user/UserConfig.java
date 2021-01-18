package pl.equipment.store.infrastructure.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.user.UserFacade;
import pl.equipment.store.domain.user.port.in.UserPort;

@Configuration
public class UserConfig {

    @Bean
    UserPort userRepository(UserSpringRepository userSpringRepository){
        return new UserFacade(new UserAdapter(userSpringRepository));
    }

}
