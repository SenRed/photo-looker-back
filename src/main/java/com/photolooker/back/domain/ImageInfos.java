package com.photolooker.back.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.nio.file.Path;

@Getter
@AllArgsConstructor
public class ImageInfos {
    private final String name;
    private final ImageStatus status;

    public ImageInfos(Path o) {
        this.name = o.getFileName().toString();
        this.status = ImageStatus.NA;
    }
}
