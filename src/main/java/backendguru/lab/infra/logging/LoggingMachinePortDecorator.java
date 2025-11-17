package backendguru.lab.infra.logging;


import backendguru.lab.application.port.MachinePort;
import backendguru.lab.infra.MachineAuditLogEntity;

public class LoggingMachinePortDecorator implements MachinePort {

    private final MachinePort target;
    private final MachineAuditLogRepository repository;

    public LoggingMachinePortDecorator(MachinePort target,
                                       MachineAuditLogRepository repository) {
        this.target = target;
        this.repository = repository;
    }

    @Override
    public void close() {
        long start = System.currentTimeMillis();

        target.close();

        long duration = System.currentTimeMillis() - start;

        repository.save(new MachineAuditLogEntity("MachinePort.close", duration));
    }

    @Override
    public void turnOn() {
        long start = System.currentTimeMillis();

        target.turnOn();

        long duration = System.currentTimeMillis() - start;

        repository.save(new MachineAuditLogEntity("MachinePort.turnOm", duration));
    }
}
