package backendguru.lab.adapter.incoming.rest.strategy.impl;

import backendguru.lab.adapter.incoming.rest.dto.response.VoiceResponse;
import backendguru.lab.adapter.incoming.rest.strategy.TurnOnResponseStrategy;
import org.springframework.stereotype.Component;

@Component
public class VoiceTurnOnStrategy implements TurnOnResponseStrategy {

    @Override
    public boolean supports(String source) {
        return "VOICE".equalsIgnoreCase(source);
    }

    @Override
    public Object buildResponse() {
        return new VoiceResponse("Ok, turning on your coffee machine.");
    }
}
