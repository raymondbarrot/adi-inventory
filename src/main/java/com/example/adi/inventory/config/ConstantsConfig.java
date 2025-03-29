package com.example.adi.inventory.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Configuration
public class ConstantsConfig {
    @Value("${kafka.topic.recommendation}")
    private String recommendationTopic;

    @Value("${kafka.topic.inventory}")
    private String inventoryTopic;

    @Value("${kafka.bootstrap.server}")
    private String kafkaServer;
}
