package iuh.fit.singletonpattern.singleton;

/**
 * Enum based Singleton
 * Instance được tạo ra tự động bởi Java
 * Ưu điểm: Thread-safe, bảo vệ khỏi reflection, serialization
 * Nhược điểm: Ít linh hoạt hơn
 * ĐÂY LÀ CÁCH AN TOÀN NHẤT
 */
public enum EnumSingleton {
    INSTANCE;
    
    private int instanceCount;
    
    EnumSingleton() {
        this.instanceCount++;
        System.out.println("EnumSingleton - Instance #" + instanceCount + " được tạo");
    }
    
    public void doSomething() {
        System.out.println("EnumSingleton doing something...");
    }
    
    public String getInfo() {
        return "Enum Singleton - Instance: " + System.identityHashCode(this);
    }
}
