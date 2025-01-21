## Requirements

Create media resources to be rendered on a view.  </br>
Media resource like playlists, author, audio, video, etc.  </br>
Create views on which resource can be shown.  </br>
Views can be of any type.  </br>
New media resources and views can be added or removed without breaking change.  </br>

## Definition of Bridge DP

It's a structural design pattern that decouples an abstraction from its implementation so that the two can vary independently.  </br></br>

The Bridge pattern uses composition instead of inheritance to separate the abstraction (what the client interacts with) from the implementation (how it works). 
This allows changes to be made to either side independently, making the design more flexible and scalable.

## Benefits

Flexibility: The abstraction and implementation can evolve independently.  </br>
Reusability: You can use the same abstraction with different implementations.  </br>
Scalability: Adding new abstractions or implementations doesn’t require modifying existing code.  </br>