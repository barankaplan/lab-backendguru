package backendguru.lab.adapter.incoming.rest.strategy.impl;

import backendguru.lab.adapter.incoming.rest.strategy.TurnOnResponseStrategy;
import org.springframework.stereotype.Component;

@Component
public class MobileTurnOnStrategy implements TurnOnResponseStrategy {

    @Override
    public boolean supports(String source) {
        return "MOBILE".equalsIgnoreCase(source);
    }

    @Override
    public Object buildResponse() {
        return "Device turned on successfully (mobile)";
    }
}
