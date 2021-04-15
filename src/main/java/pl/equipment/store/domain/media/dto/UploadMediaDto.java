package pl.equipment.store.domain.media.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class UploadMediaDto {
    private final List<MultipartFile> fileList;
    private final Long productId;
}
