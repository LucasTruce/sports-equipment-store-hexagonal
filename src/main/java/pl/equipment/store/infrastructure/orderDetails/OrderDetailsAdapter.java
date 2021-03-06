package pl.equipment.store.infrastructure.orderDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsResponseDto;
import pl.equipment.store.domain.orderDetails.dto.SaveOrderDetailsDto;
import pl.equipment.store.domain.orderDetails.port.in.OrderDetailsRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class OrderDetailsAdapter implements OrderDetailsRepository {

    private final OrderDetailsSpringRepository repository;

    @Override
    @Transactional
    public OrderDetailsResponseDto save(SaveOrderDetailsDto saveOrderDetailsDto) {

        OrderDetailsEntity entity = repository.save(OrderDetailsMapper.toOrderDetailsEntity(saveOrderDetailsDto));
        return OrderDetailsMapper.toOrderDetailsResponseDto(entity);
    }

    @Override
    public List<OrderDetailsResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(OrderDetailsMapper::toOrderDetailsResponseDto)
                .collect(Collectors.toList());
    }


}
