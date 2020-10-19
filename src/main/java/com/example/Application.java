package com.example;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.runtime.Micronaut;

@Controller
public class Application {

    @Property(name = "greeting")
    String greeting;

    @Get
    String hello() {
        return greeting + " World!";
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }
}
