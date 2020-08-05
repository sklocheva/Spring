package com.tacos.tacocloud;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.jms.Destination;

@SpringBootApplication
public class TacoCloudApplication
{
    /**
     * Used for creating a client
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

    /**
     * Setting up specific destination for messages
     *
     * @return
     */
    @Bean
    public Destination orderQueue()
    {

        return new ActiveMQQueue("tacocloud.order.queue2");
    }

    public static void main(String[] args)
    {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

}
