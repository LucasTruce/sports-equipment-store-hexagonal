package pl.equipment.store.domain.media


import pl.equipment.store.domain.media.dto.ResponseMediaDto
import pl.equipment.store.domain.media.dto.UploadMediaDto
import pl.equipment.store.domain.media.port.in.MediaRepository
import pl.equipment.store.domain.product.dto.SaveProductDto
import pl.equipment.store.domain.product.port.in.ProductRepository
import pl.equipment.store.infrastructure.media.InMemoryMediaRepository
import pl.equipment.store.infrastructure.product.InMemoryProductRepository
import spock.lang.Specification

class MediaFacadeTest extends Specification {
    MediaRepository mediaRepository = new InMemoryMediaRepository()
    ProductRepository productRepository = new InMemoryProductRepository()
    MediaFacade mediaFacade = new MediaDomainConfig().mediaFacade(mediaRepository)

    UploadMediaDto uploadMediaDto = new UploadMediaDto(null, 1L)
    SaveProductDto saveProductDto = new SaveProductDto(1L, "testProduct", "test", BigDecimal.TEN, 10, true)

    def "should create media"() {
        setup:
        productRepository.save(saveProductDto)

        when:
        List<ResponseMediaDto> list = mediaFacade.upload(new UploadMediaDto(null, 1L))

        then:
        !list.isEmpty()
        list.get(0).getUrl() == "test"
    }

    def "should find media for product"() {
        setup:
        productRepository.save(saveProductDto)
        mediaFacade.upload(new UploadMediaDto(null, 1L))

        when:
        List<ResponseMediaDto> list = mediaFacade.findForProduct(saveProductDto.getId())

        then:
        !list.isEmpty()
        list.get(0).getFileName() == "test"

    }
}
