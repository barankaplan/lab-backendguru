package backendguru.lab.infra;


import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Table(name = "machine_audit_log")
@Data
public class CoffeMachineAuditLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String methodName;

    private Long durationMs;

    private Instant createdAt;

    protected CoffeMachineAuditLogEntity() { }

    public CoffeMachineAuditLogEntity(String methodName, Long durationMs) {
        this.methodName = methodName;
        this.durationMs = durationMs;
        this.createdAt = Instant.now();
    }

    // getters (veya Lombok)
}

