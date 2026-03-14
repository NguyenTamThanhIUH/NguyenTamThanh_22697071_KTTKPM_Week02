package iuh.fit.singletonpattern.singleton;

/**
 * Lazy Initialization Singleton
 * Instance được tạo ra khi lần đầu tiên được gọi
 * Ưu điểm: Tiết kiệm tài nguyên (chỉ tạo khi cần)
 * Nhược điểm: Không thread-safe
 */
public class LazyInitializedSingleton {
    
    private static LazyInitializedSingleton instance;
    
    // Private constructor
    private LazyInitializedSingleton() {
        System.out.println("LazyInitializedSingleton instance được tạo");
    }
    
    public static LazyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializedSingleton(); // Không thread-safe!
        }
        return instance;
    }
    
    public void doSomething() {
        System.out.println("LazyInitializedSingleton doing something...");
    }
    
    public String getInfo() {
        return "Lazy Initialized Singleton - Instance: " + System.identityHashCode(this);
    }
}
