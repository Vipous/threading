package moscow.vipous;

import moscow.vipous.printer.Printer;
import moscow.vipous.printer.PrinterFactory;

public class Main {

    public static void main(String[] args) {

        PrinterFactory printerFactory = new PrinterFactory(4);
        printerFactory.addPrinter("Printer1");
        printerFactory.addPrinter("Printer2");
        printerFactory.addPrinter("Printer3");
        printerFactory.addPrinter("Printer4");
        printerFactory.print();

    }
}
