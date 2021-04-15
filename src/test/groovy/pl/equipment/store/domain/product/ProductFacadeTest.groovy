package pl.equipment.store.domain.product

import pl.equipment.store.domain.product.dto.CreateProductDto
import pl.equipment.store.domain.product.dto.ProductResponseDto
import pl.equipment.store.domain.product.port.in.ProductRepository
import pl.equipment.store.infrastructure.product.InMemoryProductRepository
import spock.lang.Specification

class ProductFacadeTest extends Specification {
    ProductRepository repository = new InMemoryProductRepository()
    ProductFacade facade = new ProductDomainConfig().productFacade(repository)

    CreateProductDto createProductDto = new CreateProductDto("test", "test", BigDecimal.valueOf(20), 10)
    CreateProductDto createProductDto2 = new CreateProductDto("test2", "test2", BigDecimal.valueOf(10), 5)

    def "should create product"() {
        when:
        def createdProduct = facade.create(createProductDto)
        then:
        createdProduct.getName() == createProductDto.getName()
        createdProduct.getDescription() == createProductDto.getDescription()
        createdProduct.getUnitPrice() == createProductDto.getUnitPrice()
        createdProduct.getUnitsInStock() == createProductDto.getUnitsInStock()
        createdProduct.getId() == 1L
    }

    def "should find all products"() {
        setup:
        facade.create(createProductDto)
        facade.create(createProductDto2)

        when:
        List<ProductResponseDto> list = facade.findAll()

        then:
        !list.isEmpty()
        list.size() == 2
    }

}
