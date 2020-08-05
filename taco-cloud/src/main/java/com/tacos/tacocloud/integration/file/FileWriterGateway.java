package com.tacos.tacocloud.integration.file;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

/**
 * @author Sophia Klocheva
 * on 8/5/2020
 * <p>
 * Declaring a massage gateway.
 */
@MessagingGateway(defaultRequestChannel = "textInChannel")
public class FileWriterGateway
{
    void writeToFile(@Header(FileHeaders.FILENAME) String name, String data)
    {
    }
}
