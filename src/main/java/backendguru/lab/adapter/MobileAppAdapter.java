//package backendguru.lab.adapter;
//
//import backendguru.lab.application.port.CloseMachinePort;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/mobile")
//public class MobileAppAdapter {
//
//    private final CloseMachinePort port;
//
//    public MobileAppAdapter(CloseMachinePort port) {
//        this.port = port;
//    }
//
//    @PostMapping("/machine/off")
//    public String turnOffFromMobile() {
//        System.out.println(">>> [ADAPTER] Mobile request received");
//        port.close();
//        return "Device turned off successfully (mobile)";
//    }
//}
//
