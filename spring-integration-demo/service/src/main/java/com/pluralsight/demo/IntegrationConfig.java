package com.pluralsight.demo;

import org.springframework.context.annotation.Configuration;

/**
 * @author Sophia Klocheva
 * on 10/15/2020
 */
@Configuration
public class IntegrationConfig
{
    // *** Java configuration
    // Used with annotation @ServiceActivator on the receiver
//    @Bean
//    public MessageChannel registrationRequest()
//    {
//        return new DirectChannel();
//    }

//
//    //*** DSL configuration
//    @Bean
//    public MessageChannel registrationRequest()
//    {
//        return MessageChannels
//                  .direct("registrationRequest")
//                  .get();
//    }
//
//    // creates a handler for the channel (same as  @ServiceActivator)
//    @Bean
//    public IntegrationFlow integrationFlow(RegistrationService service)
//    {
//        return IntegrationFlows
//                .from("registrationRequest")
//                .handle(service, "register")
//                .get();
//    }
}
