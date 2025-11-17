package backendguru.lab.adapter.incoming.rest.strategy;

public interface TurnOffResponseStrategy {
    boolean supports(String source);
    Object buildResponse();
}

