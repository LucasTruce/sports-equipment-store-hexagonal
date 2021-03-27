package pl.equipment.store.domain.order.port.in;

public interface UserDatabase {
    boolean existsById(Long userId);
}
