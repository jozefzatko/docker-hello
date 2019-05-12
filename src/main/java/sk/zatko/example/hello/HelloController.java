package sk.zatko.example.hello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        log.info("Detecting local IP address...");
        try {
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            log.info("Current local IP address is {}", ipAddress);
            return "Hello from: " + ipAddress;
        } catch (UnknownHostException e) {
            log.error("Error while detecting IP address.", e);
            return "Error while detecting IP address.";
        }
    }
}
