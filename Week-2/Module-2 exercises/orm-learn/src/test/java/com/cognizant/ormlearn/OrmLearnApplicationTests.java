package com.cognizant.ormlearn;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Smoke test that verifies the Spring application context
 * loads without any configuration or wiring errors.
 */
@SpringBootTest
class OrmLearnApplicationTests {

    @Test
    void contextLoads() {
        // If this test passes, the application context (including
        // entity scanning, repository wiring, and data-source setup)
        // was initialised correctly.
    }
}
