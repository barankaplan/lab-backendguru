package backendguru.lab.infra.logging;


import backendguru.lab.infra.MachineAuditLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineAuditLogRepository extends JpaRepository<MachineAuditLogEntity, Long> {
}

