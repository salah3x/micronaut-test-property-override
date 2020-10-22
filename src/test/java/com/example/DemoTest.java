package com.example;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.micronaut.http.HttpRequest.GET;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest(rebuildContext = true)
public class DemoTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    EmbeddedServer server;

    @Test
    void test1() {
        assertEquals(
                "Hello World!",
                client.toBlocking().retrieve(GET("/"))
        );
    }

    @Property(name = "greeting", value = "Bonjour")
    @Test
    void test2() {
        server.refresh();
        assertEquals(
                "Bonjour World!",
                client.toBlocking().retrieve(GET("/"))
        );
    }
}
