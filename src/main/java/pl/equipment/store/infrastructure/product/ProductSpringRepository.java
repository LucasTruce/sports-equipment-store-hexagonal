package pl.equipment.store.infrastructure.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSpringRepository extends JpaRepository<ProductEntity, Long> {
}
