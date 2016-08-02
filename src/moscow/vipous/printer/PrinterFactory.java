package moscow.vipous.printer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vipous on 8/2/16.
 *
 */
public class PrinterFactory {

    private List<Printer> printers = new ArrayList<>();
    private int maxLine;
    private int activePrinterId = 0;
    private boolean running;
    private int count;

    public PrinterFactory(int maxLine){
        this.maxLine = maxLine;
    }

    public Printer addPrinter(String message){
        if (running) throw new RuntimeException("Printing is running");
        Printer printer = new Printer(message, maxLine, this);
        printers.add(printer);
        printer.setId(printers.size()-1);
        return printer;
    }

    public void print(){
        running = true;
        count = printers.size();
        for (Printer p : printers) {
            Thread thread = new Thread(p);
            thread.start();
        }
    }

    synchronized void wait(int id) throws InterruptedException {
        while (activePrinterId != id) {
            wait();
        }
    }

    synchronized void switchPrinter() {
        activePrinterId = (activePrinterId + 1) % count;
        notifyAll();
    }

    synchronized int getActivePrinterId(){
        return activePrinterId;
    }



}
