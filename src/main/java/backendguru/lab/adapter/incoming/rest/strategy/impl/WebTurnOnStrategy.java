package backendguru.lab.adapter.incoming.rest.strategy.impl;

import backendguru.lab.adapter.incoming.rest.strategy.TurnOnResponseStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WebTurnOnStrategy implements TurnOnResponseStrategy {

    @Override
    public boolean supports(String source) {
        return "WEB".equalsIgnoreCase(source);
    }

    @Override
    public Object buildResponse() {
        return Map.of("status", "on", "source", "web");
    }
}
