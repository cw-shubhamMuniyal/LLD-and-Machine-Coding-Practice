## Requirements:

implement an Pool for Database Connections, where we reuse connections instead of creating new ones every time.

## Definition of Object pool design pattern:

It's used to reuse objects instead of creating and destroying them frequently. 
This is useful when object creation is expensive in terms of time or resources.

## When to use Object pool design pattern:

✅ When object creation is costly (e.g., database connections, threads, network sockets). </br>
✅ When objects are used frequently and can be recycled instead of recreated. </br>
✅ When performance needs optimization by reducing object creation overhead. </br>

## Benefits of using Object pool design pattern:

✅ Improves Performance – Reduces object creation overhead. </br>
✅ Efficient Resource Utilization – Reuses objects instead of constantly creating new ones. </br>
✅ Better Scalability – Prevents excessive memory consumption. </br>