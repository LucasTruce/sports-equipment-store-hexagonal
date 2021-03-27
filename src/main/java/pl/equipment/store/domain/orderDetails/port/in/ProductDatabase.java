package pl.equipment.store.domain.orderDetails.port.in;

import io.vavr.control.Option;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsProductDto;

public interface ProductDatabase {
    Option<OrderDetailsProductDto> getPriceAndUnitsInStock(Long productId);

    Option<Long> updateUnitsInStock(Long id, int unitsInStock);
}
