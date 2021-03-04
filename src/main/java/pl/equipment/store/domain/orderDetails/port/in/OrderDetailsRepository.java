package pl.equipment.store.domain.orderDetails.port.in;

import pl.equipment.store.domain.orderDetails.dto.OrderDetailsProductDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.SaveOrderDetailsDto;

import java.math.BigDecimal;
import java.util.List;

public interface OrderDetailsRepository {
    OrderDetailsResponseDto saveOrderDetails(SaveOrderDetailsDto saveOrderDetailsDto);

    List<OrderDetailsResponseDto> findAllOrderDetails();

    OrderDetailsProductDto getProductPriceAndUnits(Long productId);

    BigDecimal getOrderTotalPrice(Long orderId);
}
