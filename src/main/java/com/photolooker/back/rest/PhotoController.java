package com.photolooker.back.rest;

import com.photolooker.back.domain.ImageInfos;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PhotoController {

    @GetMapping("/hello")
    public List<ImageInfos> getImages() throws IOException {
        try (Stream stream = Files.list(Paths.get("/Users/senred/Documents/photos/Z 50 7805382/DCIM/100NZ_50"))) {
            return (List<ImageInfos>) stream
                    .map(o -> new ImageInfos((Path) o))
                    .collect(Collectors.toList());
        }
    }

    @GetMapping(value = "/imqsdqsdages/{name}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable String name) throws IOException {
        Path filePath = Paths.get("/Users/senred/Documents/photos/Z 50 7805382/DCIM/100NZ_50/"+name);
        return Files.readAllBytes(filePath);
    }

    @GetMapping(value = "/images/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<Resource> image(@PathVariable String name) throws IOException {
        final ByteArrayResource inputStream = new ByteArrayResource(Files.readAllBytes(Paths.get(
                "/Users/senred/Documents/photos/Z 50 7805382/DCIM/100NZ_50/"+name
        )));
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentLength(inputStream.contentLength())
                .body(inputStream);

    }
}
