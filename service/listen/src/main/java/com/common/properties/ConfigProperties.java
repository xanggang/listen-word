package com.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "web")
public class ConfigProperties {
    private String uploadPath;
    private String fileProxyPath;
}