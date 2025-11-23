package backendguru.lab.adapter.incoming.rest.strategy;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TurnOnResponseResolver {

    private final List<TurnOnResponseStrategy> strategies;

    public TurnOnResponseResolver(List<TurnOnResponseStrategy> strategies) {
        this.strategies = strategies;
    }

    public Object resolve(String source) {
        return strategies.stream()
                .filter(s -> s.supports(source))
                .findFirst()
                .map(TurnOnResponseStrategy::buildResponse)
                .orElse(ResponseEntity
                        .badRequest()
                        .body("Unsupported source for ON action: " + source));
    }
}