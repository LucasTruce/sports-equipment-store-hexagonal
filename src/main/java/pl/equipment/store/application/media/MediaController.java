package pl.equipment.store.application.media;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.equipment.store.domain.media.dto.UploadMediaDto;
import pl.equipment.store.domain.media.port.out.UploadMedia;

import java.util.List;

@RestController
@RequiredArgsConstructor
class MediaController {
    private final UploadMedia uploadMedia;

    @PostMapping("products/{productId}/media")
    ResponseEntity<?> upload(@PathVariable Long productId, @RequestPart("media") List<MultipartFile> fileList) {
        return ResponseEntity.ok(uploadMedia.upload(new UploadMediaDto(fileList, productId)));
    }
}
