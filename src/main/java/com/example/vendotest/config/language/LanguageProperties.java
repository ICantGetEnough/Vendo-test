package com.example.vendotest.config.language;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "language-mapping")
@Getter
@Setter
public class LanguageProperties {
    private Map<String, List<String>> languageMapping;
}
