package backendguru.lab.application.service;

import backendguru.lab.application.port.incoming.CoffeeMachinePowerUseCase;
import backendguru.lab.application.port.outgoing.AuditLogPort;
import org.springframework.stereotype.Service;

/**
 * APPLICATION / DOMAIN SERVICE
 * - İş kuralları burada.
 * - Incoming port'u (CoffeeMachinePowerUseCase) implemente eder.
 * - Outgoing port'u (AuditLogPort) kullanarak dış dünyaya erişir.
 */
@Service
public class CoffeeMachinePowerService implements CoffeeMachinePowerUseCase {

    private final AuditLogPort auditLogPort;

    public CoffeeMachinePowerService(AuditLogPort auditLogPort) {
        this.auditLogPort = auditLogPort;
    }

    @Override
    public void turnOff() {
        long start = System.currentTimeMillis();

        System.out.println(">>> [DOMAIN/APPLICATION] Machine is shutting down...");
        // burada gerçek iş kuralları olur

        long duration = System.currentTimeMillis() - start;
        auditLogPort.logAction("CoffeeMachine.turnOff", duration);
    }

    @Override
    public void turnOn() {
        long start = System.currentTimeMillis();

        System.out.println(">>> [DOMAIN/APPLICATION] Machine is being turned on...");
        // burada gerçek iş kuralları olur

        long duration = System.currentTimeMillis() - start;
        auditLogPort.logAction("CoffeeMachine.turnOn", duration);
    }
}
