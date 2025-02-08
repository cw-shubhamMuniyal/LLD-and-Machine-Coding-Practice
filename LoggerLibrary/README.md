- Logger : Logger is responsible for logging messages. It requires configuration during setup. Only one instance of logger is created.

- Message: It contains fields associated with Message. These fields are logged.

- Configuration: It has key value mapping of details required by logging library. It's passed to logger during set up.

- Sink: It's an interface for destination. Other Sink Types like File, Console, Database can implement Sink interface.

- FileSink: It's used for logging messages in specified filePath. Rotation and compression is also done here.

- ConsoleSink: It's used for logging messages in Console.

- FileSink and ConsoleSink override logMessage of Sink to provide their own implementation.

- SinkFactory: It's used to return Concrete Sink implementation based on SinkType.

- SinkType: Enum for defining types of sink.

- Level: Enum for defining types of Log Level.

- LoggerClient: Client calling Logger library. It has 2 methods.
    a) runFileLogger: It's used to log messages in File. Sink Type is provided in config only.
    b) runConsoleLogger: It's used to log messages in Console. Here, Client has provided its own implementation for ConsoleSink.

- How To Run?
Just need to run LoggerClient. Based on setup, messages will be logged first in file inside log folder and then in console. You can tweak client code to test further.
