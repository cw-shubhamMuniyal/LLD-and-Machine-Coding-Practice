## Definition of Proxy DP

A structural design pattern where a "proxy" object acts as a placeholder or substitute for another object, 
controlling access to the original object by performing additional actions
 like logging, caching, or access checks before forwarding requests to the real object.

## some types of Proxy

-  Virtual Proxy: 
  - Used when creating an object is resource-intensive or time-consuming.
  - The proxy delays the creation or initialization of the actual object until it is needed.

-  Remote Proxy:
  - Represents an object located in a different address space (e.g., another machine or a network).
  - Handles the communication between the client and the remote object.

-  Protection Proxy:
  - Controls access to an object based on permissions or access levels.


## Things to note

-  Proxy contains access to real subject.
- Proxy implements same interface as real subject.

## Applications

-  Caching
- pre processing of requests
- post processing of response
- Access restrictions of some features to some users.