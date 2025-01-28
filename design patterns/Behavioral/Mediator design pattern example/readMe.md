## Requirements:

-  In a chat application, users needs to send messages to each other.
-  Users need not to know about other user.

## Definition of Mediator pattern:

The Mediator Design Pattern is a behavioral design pattern that centralizes communication between multiple objects, promoting loose coupling. 
Instead of objects communicating directly with each other, they send messages to a mediator, which handles the interactions.

## Key points of Mediator pattern:

1) **Purpose:** </br>
To reduce the dependencies between communicating objects, making them easier to maintain and modify.

2) **How It Works:** </br>
Objects (referred to as colleagues) communicate through a mediator rather than interacting directly.
The mediator encapsulates how objects interact and coordinates their communication.

3) **When to Use:** </br>
When a system has many interconnected objects, and managing their communication becomes complex.
To avoid tightly coupling objects, making the system easier to extend.

## Advantages of Mediator Pattern:

1) **Loose Coupling:** </br> 
Objects are decoupled, relying on the mediator to handle interactions.

2) **Centralized Control:** </br>
The mediator manages communication logic in one place.

3) **Easier Maintenance:** </br>
Changes to communication logic affect only the mediator.

## Disadvantages of Mediator pattern:

1) **Potential Overhead:** </br> 
The mediator can become complex as it grows.

2) **Single Point of Failure:** </br> 
If the mediator fails, the system breaks.



