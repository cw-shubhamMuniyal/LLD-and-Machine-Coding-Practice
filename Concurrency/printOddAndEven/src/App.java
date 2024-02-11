public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        State state = new State(PrinterType.ODD);
        Printer oddPrinter = new Printer(state, PrinterType.ODD, PrinterType.EVEN, 50, 2, 1);
        Printer evenPrinter = new Printer(state, PrinterType.EVEN, PrinterType.ODD, 50, 2, 2);

        Thread oddThread = new Thread(oddPrinter);
        Thread evenThread = new Thread(evenPrinter);

        oddThread.start();
        evenThread.start();
    }
}
