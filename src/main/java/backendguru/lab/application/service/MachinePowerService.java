package backendguru.lab.application.service;


import org.springframework.stereotype.Service;

@Service
public class MachinePowerService {

    public void closeMachine() {
        System.out.println(">>> [APPLICATION] Machine is shutting down...");
        // burada makine kapatma iş kuralları olur
    }

    public void closeMachineAndCheckWaterLevel() {
        System.out.println(">>> [APPLICATION] Water Level is checked and Machine is shutting down...");
        // burada makine kapatma iş kuralları olur
    }

    public void turnOnMachine() {
        System.out.println(">>> [APPLICATION] Machine is being turned on...");
        // burada makine açma iş kuralları olur
    }
}

