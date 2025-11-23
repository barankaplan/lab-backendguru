package backendguru.lab.application.port.outgoing;

public interface AuditLogPort {

    void logAction(String actionName, long durationMillis);
}
