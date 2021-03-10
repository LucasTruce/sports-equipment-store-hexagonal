package pl.equipment.store.domain.orderDetails.port.in;

import io.vavr.control.Option;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsProductDto;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.SaveOrderDetailsDto;

import java.math.BigDecimal;
import java.util.List;

public interface OrderDetailsRepository {
    OrderDetailsResponseDto save(SaveOrderDetailsDto saveOrderDetailsDto);
    List<OrderDetailsResponseDto> findAll();
    Option<OrderDetailsProductDto> getProductPriceAndUnits(Long productId);
    Option<BigDecimal> getOrderTotalPrice(Long orderId);
}
