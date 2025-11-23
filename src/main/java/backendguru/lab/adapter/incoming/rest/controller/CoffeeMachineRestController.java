package backendguru.lab.adapter.incoming.rest.controller;

import backendguru.lab.adapter.incoming.rest.dto.request.PowerRequest;
import backendguru.lab.adapter.incoming.rest.strategy.TurnOffResponseResolver;
import backendguru.lab.adapter.incoming.rest.strategy.TurnOnResponseResolver;
import backendguru.lab.application.port.incoming.CoffeeMachinePowerUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/machine")
public class CoffeeMachineRestController {

    private final CoffeeMachinePowerUseCase useCase;
    private final TurnOffResponseResolver turnOffResponseResolver;
    private final TurnOnResponseResolver turnOnResponseResolver;

    public CoffeeMachineRestController(CoffeeMachinePowerUseCase useCase,
                                       TurnOffResponseResolver turnOffResponseResolver,
                                       TurnOnResponseResolver turnOnResponseResolver) {
        this.useCase = useCase;
        this.turnOffResponseResolver = turnOffResponseResolver;
        this.turnOnResponseResolver = turnOnResponseResolver;
    }

    @PostMapping("/off")
    public Object turnOff(@RequestBody PowerRequest request) {
        useCase.turnOff(); // PRIMARY PORT çağrısı (application core)
        return turnOffResponseResolver.resolve(request.source()); // REST cevabı
    }

    @PostMapping("/on")
    public Object turnOn(@RequestBody PowerRequest request) {
        useCase.turnOn(); // PRIMARY PORT çağrısı
        return turnOnResponseResolver.resolve(request.source());
    }
}
