package iuh.fit.singletonpattern.controller;

import iuh.fit.singletonpattern.service.SingletonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/singleton")
public class SingletonController {
    
    @Autowired
    private SingletonService singletonService;
    
    @GetMapping("/test-all")
    public ResponseEntity<Map<String, String>> testAllSingletons() {
        return ResponseEntity.ok(singletonService.testAllSingletons());
    }
    
    @GetMapping("/eager")
    public ResponseEntity<String> testEager() {
        return ResponseEntity.ok(singletonService.testEagerInitializedSingleton());
    }
    
    @GetMapping("/lazy")
    public ResponseEntity<String> testLazy() {
        return ResponseEntity.ok(singletonService.testLazyInitializedSingleton());
    }
    
    @GetMapping("/thread-safe")
    public ResponseEntity<String> testThreadSafe() {
        return ResponseEntity.ok(singletonService.testThreadSafeLazySingleton());
    }
    
    @GetMapping("/bill-pugh")
    public ResponseEntity<String> testBillPugh() {
        return ResponseEntity.ok(singletonService.testBillPughSingleton());
    }
    
    @GetMapping("/enum")
    public ResponseEntity<String> testEnum() {
        return ResponseEntity.ok(singletonService.testEnumSingleton());
    }
    
    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return ResponseEntity.ok(
            "Singleton Pattern - Các loại triển khai:\n" +
            "1. /api/singleton/eager - Eager Initialization\n" +
            "2. /api/singleton/lazy - Lazy Initialization (không thread-safe)\n" +
            "3. /api/singleton/thread-safe - Thread-safe Lazy\n" +
            "4. /api/singleton/bill-pugh - Bill Pugh (khuyên dùng)\n" +
            "5. /api/singleton/enum - Enum Singleton (an toàn nhất)\n" +
            "6. /api/singleton/test-all - Test tất cả các loại"
        );
    }
}
