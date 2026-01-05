package com.example.AliceAndHerBakery.module1;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BakeryConfig {
    @Bean
    @ConditionalOnProperty(name="bakery.frosting", havingValue = "chocolate")
    public Frosting chocolateFrosting() {
        return new ChocolateFrosting();
    }

    @Bean
    @ConditionalOnProperty(name="bakery.frosting", havingValue = "strawberry")
    public Frosting strawberryFrosting() {
        return new StrawberryFrosting();
    }

    @Bean
    @ConditionalOnProperty(name="bakery.syrup", havingValue = "chocolate")
    public Syrup chocolateSyrup() {
        return new ChocolateSyrup();
    }

    @Bean
    @ConditionalOnProperty(name="bakery.syrup", havingValue = "strawberry")
    public Syrup strawberrySyrup() {
        return new StrawberrySyrup();
    }
}
