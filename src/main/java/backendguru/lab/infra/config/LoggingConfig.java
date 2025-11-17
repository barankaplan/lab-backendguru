package backendguru.lab.infra.config;

import backendguru.lab.application.port.CloseMachinePort;
import backendguru.lab.application.service.MachinePowerService;
import backendguru.lab.infra.logging.LoggingCloseMachinePortDecorator;
import backendguru.lab.infra.logging.MachineAuditLogRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class LoggingConfig {

    @Bean
    @Primary
    public CloseMachinePort closeMachinePort(MachinePowerService target, MachineAuditLogRepository repository) {
        return new LoggingCloseMachinePortDecorator(target, repository);
    }
}
