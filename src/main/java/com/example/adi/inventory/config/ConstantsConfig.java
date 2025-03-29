package com.example.adi.inventory.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConstantsConfig {
    @Value("${kafka.topic.recommendation}")
    public static String RECOMMENDATION_TOPIC;

    @Value("${kafka.topic.inventory}")
    public static String INVENTORY_TOPIC;

    @Value("${kafka.bootstrap.server}")
    public static String KAFKA_SERVER;

}
