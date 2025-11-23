package backendguru.lab.application.adapter.logging;

import backendguru.lab.application.port.outgoing.AuditLogPort;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("console")
public class AuditLogConsoleOutgoingAdapter implements AuditLogPort {

    @Override
    public void logAction(String actionName, long durationMillis) {
        System.out.printf(
                "[CONSOLE-LOG] action=%s, durationMs=%d%n",
                actionName, durationMillis
        );
    }
}
