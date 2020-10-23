package com.spring.demo.springintegrationswag.pattern.event.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

/**
 * @author Sophia Klocheva
 * on 10/22/2020
 */
@Configuration
@EnableIntegration
public class EventMessagePatternConfig
{
    @Bean
    public MessageChannel eventChannel()
    {
        return new PublishSubscribeChannel();
    }
}
