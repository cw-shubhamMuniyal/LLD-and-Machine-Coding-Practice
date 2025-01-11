## Requirements

-  Log Message based on log levels. </br>
-  Add Info, Error and Debug levels. </br>
-  Any number of levels can be added in the future without modifying business logic. </br>
-  Higher level logs can shown for lower levels too. </br>
-  Lower level logs should not be shown for higher levels. </br>

## Example:

Let's say Debug level is 3, Error level is 2 and Info level is 1

- If the current log level is INFO:
  - Show only INFO messages.
- If the current log level is DEBUG:
  - Show DEBUG, ERROR and INFO messages.
- If the current log level is ERROR:
  - Show ERROR, and INFO messages.
 
## Definition:

Chain of Responsibility is a behavioral software design pattern that passes requests along a chain of objects until one of them can handle it.
