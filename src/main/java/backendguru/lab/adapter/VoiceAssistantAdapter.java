package backendguru.lab.adapter;

import backendguru.lab.application.port.CloseMachinePort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api/voice")
//public class VoiceAssistantAdapter {
//
//    private final CloseMachinePort port;
//
//    public VoiceAssistantAdapter(CloseMachinePort port) {
//        this.port = port;
//    }
//
//    @PostMapping("/machine/off")
//    public String turnOffFromVoice() {
//        System.out.println(">>> [ADAPTER] Voice command received");
//        port.close();
//        return "Ok, turning off your coffee machine.";
//    }
//}

