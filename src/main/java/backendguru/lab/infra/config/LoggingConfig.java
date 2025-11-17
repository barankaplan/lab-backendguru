package backendguru.lab.infra.config;

import backendguru.lab.application.port.MachinePort;
import backendguru.lab.application.service.MachinePowerService;
import backendguru.lab.infra.logging.LoggingMachinePortDecorator;
import backendguru.lab.infra.logging.MachineAuditLogRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class LoggingConfig {

    @Bean
    @Primary
    public MachinePort closeMachinePort(MachinePowerService target, MachineAuditLogRepository repository) {
        return new LoggingMachinePortDecorator(target, repository);
    }
}
