package pl.equipment.store.infrastructure.media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MediaSpringRepository extends JpaRepository<MediaEntity, Long> {
}
