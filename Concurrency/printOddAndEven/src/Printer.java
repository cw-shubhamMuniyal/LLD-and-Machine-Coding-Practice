public class Printer implements Runnable {
    private final  State state;
    private final PrinterType currPrinterType;
    private final PrinterType nextPrinterType;
    private final int maxSize;
    private final int step;
    private int currentValue;

    public Printer(State state, PrinterType currPrinterType, PrinterType nextPrinterType, int maxSize, int step,
            int currentValue) {
        this.state = state;
        this.currPrinterType = currPrinterType;
        this.nextPrinterType = nextPrinterType;
        this.maxSize = maxSize;
        this.step = step;
        this.currentValue = currentValue;
    }

    @Override
    public void run() {
        while (currentValue <= maxSize) {
            synchronized (state) {
                while (currPrinterType != state.getPrinterType()) {
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(currPrinterType + " " + currentValue);
                currentValue += step;
                state.setPrinterType(nextPrinterType);
                state.notifyAll();
            }
        }
    }

}
