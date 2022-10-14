package dev.carlosandrade.cleanarch.infrastructure.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "br.com.mtz.cleanarch.infrastructure.service.client")
public class InfrastructureConfiguration {
}
