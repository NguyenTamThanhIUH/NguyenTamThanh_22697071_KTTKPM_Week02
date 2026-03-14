package iuh.fit.singletonpattern.service;

import iuh.fit.singletonpattern.singleton.*;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class SingletonService {
    
    public Map<String, String> testAllSingletons() {
        Map<String, String> results = new HashMap<>();
        
        // Test Eager Initialization
        EagerInitializedSingleton eager1 = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton eager2 = EagerInitializedSingleton.getInstance();
        boolean eagerSame = eager1 == eager2;
        results.put("Eager Initialized", 
            "Same instance: " + eagerSame + " | " + eager1.getInfo());
        
        // Test Lazy Initialization
        LazyInitializedSingleton lazy1 = LazyInitializedSingleton.getInstance();
        LazyInitializedSingleton lazy2 = LazyInitializedSingleton.getInstance();
        boolean lazySame = lazy1 == lazy2;
        results.put("Lazy Initialized", 
            "Same instance: " + lazySame + " | " + lazy1.getInfo());
        
        // Test Thread-safe Lazy
        ThreadSafeLazySingleton threadSafe1 = ThreadSafeLazySingleton.getInstance();
        ThreadSafeLazySingleton threadSafe2 = ThreadSafeLazySingleton.getInstance();
        boolean threadSafeSame = threadSafe1 == threadSafe2;
        results.put("Thread-safe Lazy", 
            "Same instance: " + threadSafeSame + " | " + threadSafe1.getInfo());
        
        // Test Bill Pugh
        BillPughSingleton billPugh1 = BillPughSingleton.getInstance();
        BillPughSingleton billPugh2 = BillPughSingleton.getInstance();
        boolean billPughSame = billPugh1 == billPugh2;
        results.put("Bill Pugh", 
            "Same instance: " + billPughSame + " | " + billPugh1.getInfo());
        
        // Test Enum
        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;
        boolean enumSame = enum1 == enum2;
        results.put("Enum Singleton", 
            "Same instance: " + enumSame + " | " + enum1.getInfo());
        
        return results;
    }
    
    public String testEagerInitializedSingleton() {
        EagerInitializedSingleton singleton = EagerInitializedSingleton.getInstance();
        singleton.doSomething();
        return singleton.getInfo();
    }
    
    public String testLazyInitializedSingleton() {
        LazyInitializedSingleton singleton = LazyInitializedSingleton.getInstance();
        singleton.doSomething();
        return singleton.getInfo();
    }
    
    public String testThreadSafeLazySingleton() {
        ThreadSafeLazySingleton singleton = ThreadSafeLazySingleton.getInstance();
        singleton.doSomething();
        return singleton.getInfo();
    }
    
    public String testBillPughSingleton() {
        BillPughSingleton singleton = BillPughSingleton.getInstance();
        singleton.doSomething();
        return singleton.getInfo();
    }
    
    public String testEnumSingleton() {
        EnumSingleton singleton = EnumSingleton.INSTANCE;
        singleton.doSomething();
        return singleton.getInfo();
    }
}
