package com.photolooker.back.infra;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageKitMetaInfo {

    @JsonProperty("type")
    private String type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("createdAt")
    private String createdAt;
    @JsonProperty("updatedAt")
    private String updatedAt;
    @JsonProperty("fileId")
    private String fileId;
    @JsonProperty("tags")
    private Object tags;
    @JsonProperty("customCoordinates")
    private Object customCoordinates;
    @JsonProperty("isPrivateFile")
    private Boolean isPrivateFile;
    @JsonProperty("url")
    private String url;
    @JsonProperty("thumbnail")
    private String thumbnail;
    @JsonProperty("fileType")
    private String fileType;
    @JsonProperty("filePath")
    private String filePath;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("size")
    private Integer size;
    @JsonProperty("hasAlpha")
    private Boolean hasAlpha;
    @JsonProperty("mime")
    private String mime;
    @JsonIgnore
    private final Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("createdAt")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("createdAt")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updatedAt")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updatedAt")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("fileId")
    public String getFileId() {
        return fileId;
    }

    @JsonProperty("fileId")
    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @JsonProperty("tags")
    public Object getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Object tags) {
        this.tags = tags;
    }

    @JsonProperty("customCoordinates")
    public Object getCustomCoordinates() {
        return customCoordinates;
    }

    @JsonProperty("customCoordinates")
    public void setCustomCoordinates(Object customCoordinates) {
        this.customCoordinates = customCoordinates;
    }

    @JsonProperty("isPrivateFile")
    public Boolean getIsPrivateFile() {
        return isPrivateFile;
    }

    @JsonProperty("isPrivateFile")
    public void setIsPrivateFile(Boolean isPrivateFile) {
        this.isPrivateFile = isPrivateFile;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("thumbnail")
    public String getThumbnail() {
        return thumbnail;
    }

    @JsonProperty("thumbnail")
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @JsonProperty("fileType")
    public String getFileType() {
        return fileType;
    }

    @JsonProperty("fileType")
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    @JsonProperty("filePath")
    public String getFilePath() {
        return filePath;
    }

    @JsonProperty("filePath")
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("size")
    public Integer getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(Integer size) {
        this.size = size;
    }

    @JsonProperty("hasAlpha")
    public Boolean getHasAlpha() {
        return hasAlpha;
    }

    @JsonProperty("hasAlpha")
    public void setHasAlpha(Boolean hasAlpha) {
        this.hasAlpha = hasAlpha;
    }

    @JsonProperty("mime")
    public String getMime() {
        return mime;
    }

    @JsonProperty("mime")
    public void setMime(String mime) {
        this.mime = mime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
