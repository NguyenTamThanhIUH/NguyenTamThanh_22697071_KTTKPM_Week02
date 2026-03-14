package iuh.fit.singletonpattern.singleton;

/**
 * Eager Initialization Singleton
 * Instance được tạo ra khi class được load
 * Ưu điểm: Thread-safe, đơn giản
 * Nhược điểm: Luôn tạo instance dù có sử dụng hay không
 */
public class EagerInitializedSingleton {
    
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
    private int instanceCount = 0;
    
    // Private constructor
    private EagerInitializedSingleton() {
        this.instanceCount++;
        System.out.println("EagerInitializedSingleton - Instance #" + instanceCount + " được tạo");
    }
    
    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
    
    public void doSomething() {
        System.out.println("EagerInitializedSingleton doing something...");
    }
    
    public String getInfo() {
        return "Eager Initialized Singleton - Instance: " + System.identityHashCode(this);
    }
}
