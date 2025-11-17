package backendguru.lab.adapter.incoming.rest;

import backendguru.lab.adapter.incoming.rest.dto.TurnOffRequest;
import backendguru.lab.adapter.incoming.rest.strategy.TurnOffResponseResolver;
import backendguru.lab.application.port.MachinePort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/machine")
public class UniversalAdapter {

    private final MachinePort port;
    private final TurnOffResponseResolver resolver;

    public UniversalAdapter(MachinePort port, TurnOffResponseResolver resolver) {
        this.port = port;
        this.resolver = resolver;
    }

    @PostMapping("/off")
    public Object turnOff(@RequestBody TurnOffRequest request) {

        port.close(); // iş mantığı

        return resolver.resolve(request.source()); // strategy seç
    }

    @PostMapping("/on")
    public Object turnOn(@RequestBody TurnOffRequest request) {

        port.close(); // iş mantığı

        return resolver.resolve(request.source()); // strategy seç
    }
}

