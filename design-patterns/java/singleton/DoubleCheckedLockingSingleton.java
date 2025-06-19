class DoubleCheckedSingleton {
    // The single instance, initially null, marked as volatile
    private static volatile DoubleCheckedSingleton instance;
    
    // Private constructor to prevent instantiation
    private DoubleCheckedSingleton() {}
    
    // Public method to get the instance

    // This method ensures that the instance is created only once
    // and provides thread-safe access to the instance.
    // The first check is done without synchronization for performance,
    // and the second check is done within a synchronized block to ensure
    // that only one thread can create the instance at a time.
    // This pattern is used to avoid the overhead of synchronization
    // on every call to getInstance, while still ensuring thread safety.
    // This is known as the double-checked locking pattern.
    public static DoubleCheckedSingleton getInstance() {
        // First check (not synchronized)
        if (instance == null) {
            // Synchronize on the class object
            synchronized (DoubleCheckedSingleton.class) {
                // Second check (synchronized)
                if (instance == null) {
                    // Create the instance
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        // Return the instance (either newly created or existing)
        return instance;
    }
}