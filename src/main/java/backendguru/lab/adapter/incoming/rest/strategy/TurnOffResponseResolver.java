package backendguru.lab.adapter.incoming.rest.strategy;


import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.http.ResponseEntity;

@Component
public class TurnOffResponseResolver {

    private final List<TurnOffResponseStrategy> strategies;

    public TurnOffResponseResolver(List<TurnOffResponseStrategy> strategies) {
        this.strategies = strategies;
    }

    public Object resolve(String source) {
        return strategies.stream()
                .filter(s -> s.supports(source))
                .findFirst()
                .map(TurnOffResponseStrategy::buildResponse)
                .orElse(ResponseEntity.ok().build());
    }
}

