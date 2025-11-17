package backendguru.lab.infra.logging;


import backendguru.lab.application.port.MachinePort;
import backendguru.lab.infra.MachineAuditLogEntity;


import backendguru.lab.application.service.MachinePowerService;

public class LoggingMachinePortDecorator implements MachinePort {

    private final MachinePowerService target;
    private final MachineAuditLogRepository repository;

    public LoggingMachinePortDecorator(MachinePowerService target,
                                       MachineAuditLogRepository repository) {
        this.target = target;
        this.repository = repository;
    }

    @Override
    public void close() {
        long start = System.currentTimeMillis();

        target.closeMachine(); // business logic

        long duration = System.currentTimeMillis() - start;

        repository.save(new MachineAuditLogEntity("MachinePort.close", duration));
    }

    @Override
    public void turnOn() {
        long start = System.currentTimeMillis();

        target.turnOnMachine(); // business logic

        long duration = System.currentTimeMillis() - start;

        repository.save(new MachineAuditLogEntity("MachinePort.turnOn", duration));
    }
}
