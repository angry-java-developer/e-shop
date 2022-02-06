package microservice.eshop.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class HealthController {
    @GetMapping("health/")
    public ResponseEntity<Map<String, String>> health() {
        boolean isOk = new Random().nextBoolean();
        if (isOk) {
            Map<String, String> map = new HashMap<>();
            map.put("status", "ok");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }
}
