package backendguru.lab.adapter.incoming.rest;

import backendguru.lab.adapter.incoming.rest.dto.request.TurnOffRequest;
import backendguru.lab.adapter.incoming.rest.strategy.TurnOffResponseResolver;
import backendguru.lab.application.port.CoffeMachinePort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/machine")
public class CoffeeMachineUniversalAdapter {

    private final CoffeMachinePort port;
    private final TurnOffResponseResolver resolver;

    public CoffeeMachineUniversalAdapter(CoffeMachinePort port, TurnOffResponseResolver resolver) {
        this.port = port;
        this.resolver = resolver;
    }

    @PostMapping("/off")
    public Object turnOff(@RequestBody TurnOffRequest request) {

        port.close();

        return resolver.resolve(request.source());
    }

    @PostMapping("/on")
    public Object turnOn(@RequestBody TurnOffRequest request) {

        port.turnOn();

        return resolver.resolve(request.source());
    }
}