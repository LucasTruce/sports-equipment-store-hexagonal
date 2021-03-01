package pl.equipment.store.infrastructure.user;

import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import pl.equipment.store.domain.user.dto.SaveUserDto;
import pl.equipment.store.domain.user.dto.UserIdentificationDto;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime creationDate;


        private static final EntityMapper entityMapper = Mappers.getMapper(EntityMapper.class);

        static UserEntity toUserEntity(SaveUserDto saveUserDto){
            return entityMapper.toUserEntity(saveUserDto);
        }

        static UserIdentificationDto toUserIdentificationDto(UserEntity userEntity){
            return entityMapper.toUserIdentificationDto(userEntity);
        }

        @Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
        interface EntityMapper {
            UserIdentificationDto toUserIdentificationDto(UserEntity userEntity);
            UserEntity toUserEntity(SaveUserDto saveUserDto);
        }

}
