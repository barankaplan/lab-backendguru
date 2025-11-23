package backendguru.lab.infra.logging;


import backendguru.lab.infra.CoffeeMachineAuditLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeMachineAuditLogRepository extends JpaRepository<CoffeeMachineAuditLogEntity, Long> {
}

