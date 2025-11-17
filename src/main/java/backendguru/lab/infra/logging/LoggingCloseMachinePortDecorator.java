package backendguru.lab.infra.logging;


import backendguru.lab.application.port.CloseMachinePort;
import backendguru.lab.infra.MachineAuditLogEntity;

public class LoggingCloseMachinePortDecorator implements CloseMachinePort {

    private final CloseMachinePort target;
    private final MachineAuditLogRepository repository;

    public LoggingCloseMachinePortDecorator(CloseMachinePort target,
                                            MachineAuditLogRepository repository) {
        this.target = target;
        this.repository = repository;
    }

    @Override
    public void close() {
        long start = System.currentTimeMillis();

        // gerçek business logic
        target.close();

        long duration = System.currentTimeMillis() - start;

        repository.save(new MachineAuditLogEntity(
                "CloseMachinePort.close",
                duration
        ));
    }

    @Override
    public void turnOn() {

    }
}
