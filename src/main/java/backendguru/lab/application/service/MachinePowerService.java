package backendguru.lab.application.service;


import backendguru.lab.application.port.MachinePort;
import org.springframework.stereotype.Service;

@Service
public class MachinePowerService implements MachinePort {

    @Override
    public void close() {
        System.out.println(">>> [APPLICATION] Machine is shutting down...");
        // burada makine kapatma iş kuralları olur
    }

    @Override
    public void turnOn() {
        System.out.println(">>> [APPLICATION] Machine is being turned on ...");
        // burada makine kapatma iş kuralları olur
    }
}

