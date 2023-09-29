package com.ken.app.test.component.scan.config;

import com.ken.app.test.component.scan.common.Coach;
import com.ken.app.test.component.scan.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
