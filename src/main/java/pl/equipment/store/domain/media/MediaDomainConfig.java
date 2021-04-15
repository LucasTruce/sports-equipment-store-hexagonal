package pl.equipment.store.domain.media;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.equipment.store.domain.media.port.in.MediaRepository;

@Configuration
class MediaDomainConfig {

    @Bean
    MediaFacade mediaFacade(MediaRepository mediaRepository) {
        MediaService mediaService = new MediaService(mediaRepository);
        return new MediaFacade(mediaService);
    }

}
