package com.tacos.tacocloud.integration.file;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.integration.transformer.GenericTransformer;

import java.io.File;

import static com.sun.tools.javac.util.StringUtils.toUpperCase;

/**
 * @author Sophia Klocheva
 * on 8/5/2020
 */
@Configuration
public class FileWriterIntegrationConfig
{
    @Bean
    @Transformer(inputChannel = "textInChannel", outputChannel = "fileWriterChannel")
    public GenericTransformer<String, String> upperCaseTransformer()
    {
        return text -> toUpperCase(text);
    }

    @Bean
    @ServiceActivator(inputChannel = "fileWriterChannel")
    public FileWritingMessageHandler fileWriter()
    {
        FileWritingMessageHandler handler =
                new FileWritingMessageHandler(new File(""));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }
}
