package pl.equipment.store.infrastructure.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrderSpringRepository extends JpaRepository<OrderEntity, Long> {
}
