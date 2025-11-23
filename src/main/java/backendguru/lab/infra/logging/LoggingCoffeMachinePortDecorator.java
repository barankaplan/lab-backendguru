package backendguru.lab.infra.logging;


import backendguru.lab.application.port.CoffeMachinePort;
import backendguru.lab.infra.CoffeMachineAuditLogEntity;


import backendguru.lab.application.service.CoffeMachinePowerService;

public class LoggingCoffeMachinePortDecorator implements CoffeMachinePort {

    private final CoffeMachinePowerService target;
    private final CoffeeMachineAuditLogRepository repository;

    public LoggingCoffeMachinePortDecorator(CoffeMachinePowerService target,
                                            CoffeeMachineAuditLogRepository repository) {
        this.target = target;
        this.repository = repository;
    }

    @Override
    public void close() {
        long start = System.currentTimeMillis();

        //target.closeMachine(); // update istendi , makine kapatmadan önce suyu kontrol edelim
        target.closeMachineAndCheckWaterLevel();

        long duration = System.currentTimeMillis() - start;

        repository.save(new CoffeMachineAuditLogEntity("MachinePort.close", duration));
    }

    @Override
    public void turnOn() {
        long start = System.currentTimeMillis();

        target.turnOnMachine(); // business logic

        long duration = System.currentTimeMillis() - start;

        repository.save(new CoffeMachineAuditLogEntity("MachinePort.turnOn", duration));
    }
}
