package backendguru.lab.adapter.incoming.rest.strategy;

public interface TurnOnResponseStrategy {
    boolean supports(String source);
    Object buildResponse();
}

