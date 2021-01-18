package pl.equipment.store.infrastructure.user;

import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.user.port.shared.UserDto;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    static class EntityFactory {
        @Getter
        private static final EntityFactory instance = new EntityFactory();

        private final EntityMapper entityMapper = Mappers.getMapper(EntityMapper.class);

        UserEntity toUserEntity(UserDto userDto){
            return entityMapper.toUserEntity(userDto);
        }

        UserDto toUserDto(UserEntity userEntity){
            return entityMapper.toUserDto(userEntity);
        }

        @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
        interface EntityMapper {
            UserDto toUserDto(UserEntity userEntity);
            UserEntity toUserEntity(UserDto userDto);
        }
    }
}
