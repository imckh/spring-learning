package hello.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * https://docs.spring.io/spring-boot/docs/2.0.5.RELEASE/reference/html/configuration-metadata.html#configuration-metadata-annotation-processor
 * B.3
 *
 * 根据以上的文档, 这里需要添加spring-boot-configuration-processor依赖
 * @author CKH
 * @date 2018/12/20 21:18
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
