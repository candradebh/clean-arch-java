package dev.carlosandrade.cleanarch.infrastructure.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "dev.carlosandrade.cleanarch.infrastructure.service.client")
public class InfrastructureConfiguration {
}
