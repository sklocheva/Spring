package com.spring.demo.springintegrationswag.pattern.document.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@Configuration
@EnableIntegration
public class DocumentMessagePatternConfig
{
    @Bean
    public MessageChannel registrationRecordChannel()
    {
        return new DirectChannel();
    }
}
