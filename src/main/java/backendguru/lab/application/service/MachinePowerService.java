package backendguru.lab.application.service;


import backendguru.lab.application.port.CloseMachinePort;
import org.springframework.stereotype.Service;

@Service
public class MachinePowerService implements CloseMachinePort {

    @Override
    public void close() {
        System.out.println(">>> [APPLICATION] Machine is shutting down...");
        // burada makine kapatma iş kuralları olur
    }
}

