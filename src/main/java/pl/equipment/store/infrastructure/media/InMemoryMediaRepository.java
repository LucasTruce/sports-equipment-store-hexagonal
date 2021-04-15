package pl.equipment.store.infrastructure.media;

import org.springframework.web.multipart.MultipartFile;
import pl.equipment.store.domain.media.dto.ResponseMediaDto;
import pl.equipment.store.domain.media.dto.SaveMediaDto;
import pl.equipment.store.domain.media.port.in.MediaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryMediaRepository implements MediaRepository {
    ConcurrentHashMap<Long, MediaEntity> map = new ConcurrentHashMap<>();
    Long id = 1L;

    @Override
    public List<ResponseMediaDto> upload(List<MultipartFile> files) {
        List<ResponseMediaDto> list = new ArrayList<>();
        list.add(new ResponseMediaDto("test", "test"));
        list.add(new ResponseMediaDto("test2", "test2"));
        list.add(new ResponseMediaDto("test3", "test3"));
        return list;
    }

    @Override
    public List<ResponseMediaDto> save(List<SaveMediaDto> medias) {
        return medias
                .stream()
                .map(MediaMapper::toEntity)
                .peek(mediaEntity -> {
                    mediaEntity.setId(id);
                    map.put(id++, mediaEntity);
                })
                .map(MediaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ResponseMediaDto> findAllByProductId(Long productId) {
        return map.values()
                .stream()
                .filter(mediaEntity -> mediaEntity.getId().equals(productId))
                .map(MediaMapper::toResponse)
                .collect(Collectors.toList());
    }
}
