package pl.equipment.store.domain.media.port.out;

import pl.equipment.store.domain.media.dto.ResponseMediaDto;

import java.util.List;

public interface FindMedia {
    List<ResponseMediaDto> findForProduct(Long productId);
}
