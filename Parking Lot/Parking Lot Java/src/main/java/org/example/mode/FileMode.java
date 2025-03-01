package org.example.mode;

import org.example.command.CommandExecutorFactory;

import java.io.*;

public class FileMode extends Mode {

    private final String fileName;

    public FileMode(CommandExecutorFactory commandExecutorFactory, String fileName) {
        super(commandExecutorFactory);
        this.fileName = fileName;
    }

    @Override
    public  void process() throws Exception {

        final File file = new File(fileName);
        final BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("Invalid file!");
            return;
        }

        String input = reader.readLine();
        while (input != null) {
            processCommand(input);
            input = reader.readLine();
        }

    }
}
