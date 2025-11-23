package backendguru.lab.adapter;

import backendguru.lab.application.port.CoffeMachinePort;
import backendguru.lab.infra.CoffeeMachineAuditLogEntity;
import backendguru.lab.application.service.CoffeeMachinePowerService;
import backendguru.lab.infra.logging.CoffeeMachineAuditLogRepository;

public class CoffeMachineAdapter implements CoffeMachinePort {

    private final CoffeeMachinePowerService target;
    private final CoffeeMachineAuditLogRepository repository;

    public CoffeMachineAdapter(CoffeeMachinePowerService target, CoffeeMachineAuditLogRepository repository) {
        this.target = target;
        this.repository = repository;
    }

    @Override
    public void close() {
        long start = System.currentTimeMillis();

        //target.closeMachine(); // update istendi , makine kapatmadan önce suyu kontrol edelim
        target.turnOff();

        long duration = System.currentTimeMillis() - start;

        repository.save(new CoffeeMachineAuditLogEntity("MachinePort.close", duration));
    }

    @Override
    public void turnOn() {
        long start = System.currentTimeMillis();

        target.turnOn(); // business logic

        long duration = System.currentTimeMillis() - start;

        repository.save(new CoffeeMachineAuditLogEntity("MachinePort.turnOn", duration));
    }
}
