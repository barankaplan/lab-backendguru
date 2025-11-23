package backendguru.lab.application.adapter.logging;

import backendguru.lab.application.port.outgoing.AuditLogPort;
import backendguru.lab.infra.CoffeeMachineAuditLogEntity;
import backendguru.lab.infra.logging.CoffeeMachineAuditLogRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * SECONDARY ADAPTER
 * - AuditLogPort'u JPA dünyasına adapte eder.
 * - Domain, bu sınıftan haberdar değildir; sadece AuditLogPort bilir.
 */
@Component
@Profile("jpa")
public class AuditLogJpaOutgoingAdapter implements AuditLogPort {

    private final CoffeeMachineAuditLogRepository repository;

    public AuditLogJpaOutgoingAdapter(CoffeeMachineAuditLogRepository repository) {
        this.repository = repository;
    }

    @Override
    public void logAction(String actionName, long durationMillis) {
        CoffeeMachineAuditLogEntity entity = new CoffeeMachineAuditLogEntity(actionName, durationMillis);
        repository.save(entity);
    }
}
