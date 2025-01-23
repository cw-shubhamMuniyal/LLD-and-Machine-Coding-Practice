## Definition

It's creational pattern that ensures that a class has only one instance and provides a global point of access to that instance.

## Explanation

-  **Volatile Keyword**: Ensures that changes to the instance variable are visible to all threads.
Prevents the compiler from reordering instructions related to the instance variable.

- **Private Constructor**: Restricts instantiation of the class from outside, ensuring only one instance is created.

- **Double-Checked Locking**: The first if (instance == null) check avoids unnecessary synchronization for already-initialized instances, improving performance.
The second check inside the synchronized block ensures thread safety during the first initialization.

- **Thread-Safe Singleton**: The use of synchronized ensures that only one thread can create the instance at a time, avoiding multiple creations in a multithreaded environment.

- **Lazy Initialization**: The instance is created only when it is first accessed, saving resources if it’s never used.