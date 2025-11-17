package backendguru.lab.adapter.incoming.rest.strategy.impl;


import backendguru.lab.adapter.incoming.rest.strategy.TurnOffResponseStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WebTurnOffStrategy implements TurnOffResponseStrategy {

    @Override
    public boolean supports(String source) {
        return "WEB".equalsIgnoreCase(source);
    }

    @Override
    public Object buildResponse() {
        return Map.of("status", "off", "source", "web");
    }
}

