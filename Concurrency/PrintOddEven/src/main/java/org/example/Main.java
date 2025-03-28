package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Learning Threads!");

        State state = new State(PrinterType.ODD);

        Printer oddPrinter = new Printer(2, 50, state, PrinterType.ODD,
                PrinterType.EVEN, 1);

        Printer evenPrinter = new Printer(2, 50, state, PrinterType.EVEN,
                PrinterType.ODD, 2);

        Thread evenThread = new Thread(evenPrinter);
        Thread oddThread = new Thread(oddPrinter);

        evenThread.start();
        oddThread.start();

    }
}