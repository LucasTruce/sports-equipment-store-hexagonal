package pl.equipment.store.infrastructure.product;

import io.vavr.control.Option;
import pl.equipment.store.domain.orderDetails.dto.OrderDetailsProductDto;
import pl.equipment.store.domain.orderDetails.port.in.ProductDatabase;
import pl.equipment.store.domain.product.dto.ProductResponseDto;
import pl.equipment.store.domain.product.dto.SaveProductDto;
import pl.equipment.store.domain.product.port.in.ProductRepository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryProductRepository implements ProductRepository, ProductDatabase {

    ConcurrentHashMap<Long, ProductEntity> hashMap = new ConcurrentHashMap<>();
    Long i = 1L;

    @Override
    public ProductResponseDto save(SaveProductDto saveProductDto) {
        ProductEntity entity = ProductMapper.toEntity(saveProductDto);
        entity.setId(i);
        hashMap.put(i++, entity);
        return ProductMapper.toResponseDto(entity);
    }

    @Override
    public List<ProductResponseDto> findAll() {
        return hashMap.values()
                .stream()
                .map(ProductMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Option<OrderDetailsProductDto> getPriceAndUnitsInStock(Long productId) {
        return Option.of(hashMap.get(productId))
                .map(ProductMapper::toProductDto);
    }

    @Override
    public Option<Long> updateUnitsInStock(Long id, int unitsInStock) {
        return Option.of(hashMap.get(id))
                .peek(product -> product.setUnitsInStock(unitsInStock))
                .map(ProductEntity::getId);
    }

}
