package org.example;

import java.util.List;

public class Directory implements FileSystem {

    String directoryName;
    List<FileSystem> fileSystemList;

    Directory(String directoryName, List<FileSystem> fileSystemList) {

        this.directoryName = directoryName;
        this.fileSystemList = fileSystemList;
    }

    @Override
    public void printName() {

        System.out.println("Directory with name " + directoryName + ":");
        int index = 1;
        for(FileSystem fileSystem : fileSystemList) {
            System.out.print(index++ + " ");
            fileSystem.printName();
        }
        System.out.println();

    }
}
