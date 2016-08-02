package moscow.vipous.printer;

/**
 * Created by vipous on 8/2/16.
 *
 */
public class Printer implements Runnable {

    private int id;
    private String message;
    private int maxLine;
    private PrinterFactory factory;

    Printer(String message, int maxLine, PrinterFactory factory) {
        this.message = message;
        this.maxLine = maxLine;
        this.factory = factory;
    }

    @Override
    public void run() {
        for (int i = 0; i < maxLine; i++) {
            try
            {
                factory.wait(id);
                message(message);
                factory.switchPrinter();
            } catch (InterruptedException e) {}
        }
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    private void message(String message){
        synchronized (System.out) {
            System.out.print(message);
            System.out.println();
        }
    }
}
