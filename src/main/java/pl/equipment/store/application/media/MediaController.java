package pl.equipment.store.application.media;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.equipment.store.domain.media.dto.ResponseMediaDto;
import pl.equipment.store.domain.media.dto.UploadMediaDto;
import pl.equipment.store.domain.media.port.out.FindMedia;
import pl.equipment.store.domain.media.port.out.UploadMedia;

import java.util.List;

@RestController
@RequiredArgsConstructor
class MediaController {
    private final UploadMedia uploadMedia;
    private final FindMedia findMedia;

    @PostMapping("products/{productId}/media")
    ResponseEntity<?> upload(@PathVariable Long productId, @RequestPart("media") List<MultipartFile> fileList) {
        return ResponseEntity.ok(uploadMedia.upload(new UploadMediaDto(fileList, productId)));
    }

    @GetMapping("/products/{productId}/media")
    ResponseEntity<List<ResponseMediaDto>> findAllForProduct(@PathVariable Long productId) {
        return ResponseEntity.ok(findMedia.findForProduct(productId));
    }
}
