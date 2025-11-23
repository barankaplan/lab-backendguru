package backendguru.lab.infra.logging;


import backendguru.lab.infra.CoffeMachineAuditLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeMachineAuditLogRepository extends JpaRepository<CoffeMachineAuditLogEntity, Long> {
}

