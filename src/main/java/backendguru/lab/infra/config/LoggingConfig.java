package backendguru.lab.infra.config;

import backendguru.lab.application.port.CoffeMachinePort;
import backendguru.lab.application.service.CoffeMachinePowerService;
import backendguru.lab.infra.logging.LoggingCoffeMachinePortDecorator;
import backendguru.lab.infra.logging.CoffeeMachineAuditLogRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {

    @Bean
    public CoffeMachinePort closeMachinePort(CoffeMachinePowerService target, CoffeeMachineAuditLogRepository repository) {
        return new LoggingCoffeMachinePortDecorator(target, repository);
    }
}
