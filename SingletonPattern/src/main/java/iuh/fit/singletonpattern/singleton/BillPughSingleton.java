package iuh.fit.singletonpattern.singleton;

/**
 * Bill Pugh Singleton Pattern (Double Checked Locking)
 * Instance được tạo ra khi lần đầu tiên được gọi
 * Ưu điểm: Thread-safe, hiệu suất cao (chỉ check lock một lần)
 * Nhược điểm: Phức tạp hơn
 * ĐÂY LÀ CÁCH ĐƯỢC KHUYÊN DÙNG NHẤT
 */
public class BillPughSingleton {
    
    private static BillPughSingleton instance;
    
    // Private constructor
    private BillPughSingleton() {
        System.out.println("BillPughSingleton instance được tạo");
    }
    
    // Static helper class
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    public void doSomething() {
        System.out.println("BillPughSingleton doing something...");
    }
    
    public String getInfo() {
        return "Bill Pugh Singleton - Instance: " + System.identityHashCode(this);
    }
}
