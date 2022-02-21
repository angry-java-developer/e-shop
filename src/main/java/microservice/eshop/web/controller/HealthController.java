package microservice.eshop.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HealthController {
    @Value("${VERSION}")
    private String version;


    @GetMapping("health/")
    public ResponseEntity<Map<String, String>> health() {
        Map<String, String> map = new HashMap<>();
        map.put("node", "version=" + version);
        map.put("status", "ok");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
