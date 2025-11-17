package backendguru.lab.adapter.incoming.rest.strategy.impl;


import backendguru.lab.adapter.incoming.rest.strategy.TurnOffResponseStrategy;
import org.springframework.stereotype.Component;

@Component
public class MobileTurnOffStrategy implements TurnOffResponseStrategy {

    @Override
    public boolean supports(String source) {
        return "MOBILE".equalsIgnoreCase(source);
    }

    @Override
    public Object buildResponse() {
        return "Device turned off successfully (mobile)";
    }
}

