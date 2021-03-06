package pl.equipment.store.infrastructure.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProductSpringRepository extends JpaRepository<ProductEntity, Long> {
}
