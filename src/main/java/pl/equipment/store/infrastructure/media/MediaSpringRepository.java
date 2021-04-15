package pl.equipment.store.infrastructure.media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface MediaSpringRepository extends JpaRepository<MediaEntity, Long> {
    List<MediaEntity> findAllByProductEntityId(Long productId);
}
