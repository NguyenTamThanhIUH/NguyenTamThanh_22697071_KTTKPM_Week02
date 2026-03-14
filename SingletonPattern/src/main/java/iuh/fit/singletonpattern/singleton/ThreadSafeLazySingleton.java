package iuh.fit.singletonpattern.singleton;

/**
 * Thread-safe Lazy Initialization Singleton
 * Instance được tạo ra khi lần đầu tiên được gọi, thread-safe
 * Ưu điểm: Thread-safe, tiết kiệm tài nguyên
 * Nhược điểm: Synchronized có thể ảnh hưởng đến performance
 */
public class ThreadSafeLazySingleton {
    
    private static ThreadSafeLazySingleton instance;
    
    // Private constructor
    private ThreadSafeLazySingleton() {
        System.out.println("ThreadSafeLazySingleton instance được tạo");
    }
    
    public static synchronized ThreadSafeLazySingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeLazySingleton();
        }
        return instance;
    }
    
    public void doSomething() {
        System.out.println("ThreadSafeLazySingleton doing something...");
    }
    
    public String getInfo() {
        return "Thread-safe Lazy Singleton - Instance: " + System.identityHashCode(this);
    }
}
