package com.example.validated;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ValidatedApplicationTests {

    @Test
    void contextLoads() {
        UUID uuid = UUID.fromString("46400000-8cc0-11bd-b43e-10d46e4ef14d");

        // Display UUID
        System.out.println(" UUID.fromString(): " + uuid);

    }

}
