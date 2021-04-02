package pl.equipment.store.infrastructure.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserSpringRepository extends JpaRepository<UserEntity, Long> {
}
