package com.robeil.demoproject.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomHelathIndicator  implements HealthIndicator {

private final Logger logger = LoggerFactory.getLogger(RandomHelathIndicator.class);
    @Override
    public Health health() {
        double chance = ThreadLocalRandom.current().nextDouble();
        Health.Builder status = Health.up(); // Assume up by default
        if (chance > 0.9) {
            status = Health.down(); // Report as down 10% of the time
            logger.info(status.toString());

        }
        logger.info(status.toString());
        return status.build();
    }
}
