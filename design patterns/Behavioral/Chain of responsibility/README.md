## Requirements

-  Log Message based on log levels. </br>
-  Add Info, Error and Debug levels. </br>
-  Any number of levels can be added in the future without modifying business logic. </br>
-  Higher level logs can shown for lower levels too. </br>
-  Lower level logs should not be shown for higher levels. </br>

## Example:
- If the current log level is INFO:
  - Show only INFO messages.
- If the current log level is DEBUG:
  - Show DEBUG, ERROR and INFO messages.
- If the current log level is ERROR:
  - Show ERROR, and INFO messages.
