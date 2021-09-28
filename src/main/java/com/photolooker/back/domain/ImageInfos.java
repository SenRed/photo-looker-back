package com.photolooker.back.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ImageInfos {
    private final String name;
    private final String originalImageURL;
    private final String thumbedImageURL;
    private ImageStatus status;

    public void validate(){
        this.status = ImageStatus.OK;
    }

}
