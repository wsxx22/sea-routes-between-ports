package com.searoutes.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
@Component
@ConfigurationProperties(prefix = "customproperties")
public class YamlProperties {

    @NotBlank
    private String historicalRoutesFileName;
}
