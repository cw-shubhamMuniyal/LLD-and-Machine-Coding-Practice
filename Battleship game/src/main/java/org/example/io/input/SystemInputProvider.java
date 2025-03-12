package org.example.io.input;

import lombok.SneakyThrows;
import org.example.exception.InvalidInputException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SystemInputProvider implements InputProvider {

    @Override
    @SneakyThrows
    public PlayerInput takeInput() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().trim().split(" ");

        if (input.length != 3) {
            throw new InvalidInputException();
        }

        return new PlayerInput(
                Integer.valueOf(input[0]),
                Integer.valueOf(input[1]),
                Integer.valueOf(input[2])
        );
    }
}
