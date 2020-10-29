package com.spring.demo.springintegrationswag.channel.queue;

import com.spring.demo.springintegrationswag.channel.queue.service.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author Sophia Klocheva
 * on 10/23/2020
 */
@Slf4j
@SpringBootApplication
public class QueueChannelApplication implements CommandLineRunner, ExitCodeGenerator
{
    @Autowired
    private RegistrationService service;

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args)
    {
        SpringApplication.run(QueueChannelApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        service.commit("123");
        try
        {
            Thread.sleep(10000);
        }
        catch (Exception e)
        {
        }

        log.info("Shutdown app after 10 second delay");
        SpringApplication.exit(context, this);
    }

    @Override
    public int getExitCode()
    {
        return 0;
    }
}
