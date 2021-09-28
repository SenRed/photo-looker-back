package com.photolooker.back.rest;

import com.photolooker.back.domain.ImageInfos;
import com.photolooker.back.infra.ImageKitStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@Configuration
@Component
@PropertySource("classpath:application.yml")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PhotoController {


    private List<ImageInfos> allImages;

    @Autowired
    private ImageKitStoreService imageKitStore;

    @PostConstruct
    public void fetchImagesMeta(){
        this.allImages = imageKitStore.getAllImagesMeta();
    }

    @GetMapping("/images")
    public List<ImageInfos> getImages() {
        return this.allImages;
    }

    @PostMapping(value = "/{name}",produces = MediaType.IMAGE_JPEG_VALUE)
    public void validateImage(@PathVariable String name) throws ImageNotFoundException {
        final ImageInfos validatedImage = this.allImages.stream()
                .filter(image -> image.getName().equals(name))
                .findFirst()
                .orElseThrow(ImageNotFoundException::new);
        validatedImage.validate();
    }
}
