package com.spring.demo.springintegrationswag.channel.queue.config;

import com.spring.demo.springintegrationswag.pattern.command.model.Swag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PriorityChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.Comparator;

/**
 * @author Sophia Klocheva
 * on 10/23/2020
 */
@Configuration
@EnableIntegration
public class QueueChannelConfig
{
    @Bean
    public MessageChannel queueChannel()
    {
        return new QueueChannel(10);
    }

    //Priority Queue examples
    //Priority is set to the message properties
    @Bean
    public MessageChannel priorityChannel()
    {
        return new PriorityChannel();
    }

    @Bean
    public MessageChannel customPriorityChannel()
    {
        return new PriorityChannel();
//                Comparator.comparingLong(
//                        (Message<?> m) -> ((Swag) m.getPayload()).getAmaunt()).reversed());

    }
}
