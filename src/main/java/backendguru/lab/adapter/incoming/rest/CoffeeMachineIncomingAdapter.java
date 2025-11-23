package backendguru.lab.adapter.incoming.rest;

import backendguru.lab.adapter.incoming.rest.dto.request.ActionRequest;
import backendguru.lab.adapter.incoming.rest.strategy.TurnOffResponseResolver;
import backendguru.lab.adapter.incoming.rest.strategy.TurnOnResponseResolver;
import backendguru.lab.application.port.incoming.CoffeeMachineIncomingPort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/machine")
public class CoffeeMachineIncomingAdapter {

    private final CoffeeMachineIncomingPort useCase; // uygulamanin disa actigi usa case api ,primary/driving port
    private final TurnOffResponseResolver turnOffResponseResolver;
    private final TurnOnResponseResolver turnOnResponseResolver;

    public CoffeeMachineIncomingAdapter(CoffeeMachineIncomingPort useCase,
                                        TurnOffResponseResolver turnOffResponseResolver,
                                        TurnOnResponseResolver turnOnResponseResolver) {
        this.useCase = useCase;
        this.turnOffResponseResolver = turnOffResponseResolver;
        this.turnOnResponseResolver = turnOnResponseResolver;
    }

    @PostMapping("/off")
    public Object turnOff(@RequestBody ActionRequest request) {
        useCase.turnOff(); // PRIMARY PORT çağrısı (application core)
        return turnOffResponseResolver.resolve(request.source()); // REST cevabı
    }

    @PostMapping("/on")
    public Object turnOn(@RequestBody ActionRequest request) {
        useCase.turnOn(); // PRIMARY PORT çağrısı
        return turnOnResponseResolver.resolve(request.source());
    }
}
