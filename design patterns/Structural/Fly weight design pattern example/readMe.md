## Requirements:

Create a game containing multiple and different types of robots.  </br>
Each robot type should have a unique appearance (image or sprite).  </br>
Each robot instance should have unique attributes, like Position (x, y coordinates) on the game map.  </br>
Make sure **memory** is efficiently utilized.  </br>

## Definition of Fly Weight pattern:

It's a structural design pattern that reduces memory usage by sharing data between similar objects.

## Benefits: 

- Reduced Memory Usage: By sharing intrinsic data, the Flyweight pattern minimizes the memory footprint.
- Flexibility in Object Management: Separating intrinsic state (shared data) from extrinsic state (unique data) provides flexibility.
- Supports Immutable Design: Intrinsic state is often designed to be immutable (unchanging), which simplifies thread safety and consistency in shared objects.


## Example Applications:

- Games: Shared models, textures, or animations for multiple characters or objects.
- Graphics Rendering: Shared shapes, icons, or glyphs.
- Document Editors: Sharing font characters or formatting styles.
- Caching Systems: Reusing frequently accessed objects.