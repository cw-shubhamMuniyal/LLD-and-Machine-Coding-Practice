package org.example;

import java.util.ArrayList;
import java.util.List;

public class FileSystemApp {
    public static void main(String[] args) {

        System.out.println("Design file system using Composite Design pattern!");
        System.out.println("___________________________________________________");


        FileSystem factoryMethod = new File("Factory method");
        FileSystem absoluteFactoryMethod = new File("Absolute Factory method");

        FileSystem decorator = new File("Decorator");
        FileSystem composite = new File("Composite");

        FileSystem strategy = new File("strategy");
        FileSystem chainOfResponsibility = new File("Chain of responsibility");

        FileSystem creational = new Directory(
                "Creational",
                List.of(factoryMethod, absoluteFactoryMethod)
        );
        FileSystem behavioural = new Directory(
                "Behavioural",
                List.of(chainOfResponsibility, strategy)
        );
        FileSystem structural = new Directory(
                "Structural",
                List.of(decorator, composite)
        );


        FileSystem designPatterns = new Directory(
                "Design Patterns",
                List.of(creational, behavioural, structural)
        );

        designPatterns.printName();
    }
}