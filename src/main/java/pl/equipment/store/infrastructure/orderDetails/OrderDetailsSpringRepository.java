package pl.equipment.store.infrastructure.orderDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsSpringRepository extends JpaRepository<OrderDetailsEntity, Long> {
}
