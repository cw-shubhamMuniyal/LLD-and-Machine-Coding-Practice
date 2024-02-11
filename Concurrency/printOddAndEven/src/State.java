public class State {
    PrinterType nextToPrint;

    public PrinterType getPrinterType() {
        return nextToPrint;
    }

    public void setPrinterType(PrinterType nextToPrint) {
        this.nextToPrint = nextToPrint;
    }

    public State(PrinterType nextToPrint) {
        this.nextToPrint = nextToPrint;
    }
}
