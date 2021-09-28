package com.photolooker.back.infra;

import com.photolooker.back.domain.ImageInfos;
import com.photolooker.back.domain.ImageStatus;
import com.photolooker.back.domain.ImageStoreService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageKitStoreService implements ImageStoreService {

    @Value("${imageStore.privateUserKey}")
    public String privateUserKey;

    final String STORE_BASE_URL = "https://api.imagekit.io/v1/";

    @Override
    public List<ImageInfos> getAllImagesMeta() {
        ResponseEntity<List<ImageKitMetaInfo>> rateResponse =
                new RestTemplate().exchange(STORE_BASE_URL + "files",
                        HttpMethod.GET,
                        new HttpEntity<>(createHeaders()),
                        new ParameterizedTypeReference<>() {});
        List<ImageKitMetaInfo> imagesMetasInfos = rateResponse.getBody();
        return imagesMetasInfos
                .stream()
                .map(imageKitMetaInfo -> new ImageInfos(imageKitMetaInfo.getName(), imageKitMetaInfo.getUrl(), imageKitMetaInfo.getThumbnail(), ImageStatus.NA))
                .collect(Collectors.toList());
    }

    HttpHeaders createHeaders() {
        return new HttpHeaders() {{
            String auth = privateUserKey + ":" + "";
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(StandardCharsets.US_ASCII));
            String authHeader = "Basic " + new String(encodedAuth);
            set("Authorization", authHeader);
        }};
    }
}
