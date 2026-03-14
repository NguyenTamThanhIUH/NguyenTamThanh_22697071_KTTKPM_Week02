package iuh.fit.singletonpattern;

import iuh.fit.singletonpattern.singleton.*;
import iuh.fit.singletonpattern.service.SingletonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SingletonPatternApplicationTests {

    @Autowired
    private SingletonService singletonService;

    @Test
    void contextLoads() {
        assertNotNull(singletonService);
    }

    @Test
    void testEagerInitializedSingleton() {
        // Lần thứ 1
        EagerInitializedSingleton instance1 = EagerInitializedSingleton.getInstance();
        // Lần thứ 2
        EagerInitializedSingleton instance2 = EagerInitializedSingleton.getInstance();
        
        // Kiểm tra cùng instance
        assertSame(instance1, instance2);
        System.out.println("✓ EagerInitializedSingleton: " + instance1.getInfo());
    }

    @Test
    void testLazyInitializedSingleton() {
        // Lần thứ 1
        LazyInitializedSingleton instance1 = LazyInitializedSingleton.getInstance();
        // Lần thứ 2
        LazyInitializedSingleton instance2 = LazyInitializedSingleton.getInstance();
        
        // Kiểm tra cùng instance
        assertSame(instance1, instance2);
        System.out.println("✓ LazyInitializedSingleton: " + instance1.getInfo());
    }

    @Test
    void testThreadSafeLazySingleton() {
        // Lần thứ 1
        ThreadSafeLazySingleton instance1 = ThreadSafeLazySingleton.getInstance();
        // Lần thứ 2
        ThreadSafeLazySingleton instance2 = ThreadSafeLazySingleton.getInstance();
        
        // Kiểm tra cùng instance
        assertSame(instance1, instance2);
        System.out.println("✓ ThreadSafeLazySingleton: " + instance1.getInfo());
    }

    @Test
    void testBillPughSingleton() {
        // Lần thứ 1
        BillPughSingleton instance1 = BillPughSingleton.getInstance();
        // Lần thứ 2
        BillPughSingleton instance2 = BillPughSingleton.getInstance();
        
        // Kiểm tra cùng instance
        assertSame(instance1, instance2);
        System.out.println("✓ BillPughSingleton: " + instance1.getInfo());
    }

    @Test
    void testEnumSingleton() {
        // Lần thứ 1
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        // Lần thứ 2
        EnumSingleton instance2 = EnumSingleton.INSTANCE;
        
        // Kiểm tra cùng instance
        assertSame(instance1, instance2);
        System.out.println("✓ EnumSingleton: " + instance1.getInfo());
    }

    @Test
    void testAllSingletonsViaService() {
        Map<String, String> results = singletonService.testAllSingletons();
        
        assertNotNull(results);
        assertEquals(5, results.size());
        
        results.forEach((key, value) -> {
            System.out.println(key + ": " + value);
            assertTrue(value.contains("true"), "Instance phải là singleton");
        });
    }

    @Test
    void testSingletonWithMultipleGets() {
        // Test eager
        EagerInitializedSingleton eager1 = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton eager2 = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton eager3 = EagerInitializedSingleton.getInstance();
        
        assertSame(eager1, eager2);
        assertSame(eager2, eager3);
        assertEquals(eager1.hashCode(), eager3.hashCode());
        
        System.out.println("✓ Eager Singleton luôn là cùng một instance");
    }

    @Test
    void testBillPughVsOthers() {
        BillPughSingleton billPugh1 = BillPughSingleton.getInstance();
        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        
        assertNotNull(billPugh1);
        assertNotNull(enum1);
        
        System.out.println("✓ Bill Pugh và Enum đều là Singleton");
    }
}
