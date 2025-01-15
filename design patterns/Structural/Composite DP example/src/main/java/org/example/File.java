package org.example;

public class File implements FileSystem {

    String fileName;

    File(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void printName() {
        System.out.println("File with name " + fileName);
    }
}
