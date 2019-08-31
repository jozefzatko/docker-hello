package sk.zatko.example.hello.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@Service
public class HelloService {

    @Value("${app.name}")
    private String appName;

    public String sayHello() {
        log.info("Detecting local IP address...");
        try {
            String ipAddress = InetAddress.getLocalHost().getHostAddress();
            log.info("Current local IP address is {}", ipAddress);
            return appName + " saying good afternoon from: " + ipAddress;
        } catch (UnknownHostException e) {
            log.error("Error while detecting IP address.", e);
            return "Error while detecting IP address.";
        }
    }
}
