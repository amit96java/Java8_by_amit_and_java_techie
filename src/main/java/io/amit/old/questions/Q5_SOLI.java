package io.amit.old.questions;

/**
 * No client should be forced to depend on methods it does not use.
 */

// Segregated interfaces
interface Printer {
    void printDocument();
}

interface Scanner {
    void scanDocument();
}

class MultiFunctionPrinter implements Printer, Scanner {
    public void printDocument() {
        System.out.println("Printing document");
    }

    public void scanDocument() {
        System.out.println("Scanning document");
    }
}

class SimplePrinter implements Printer {
    public void printDocument() {
        System.out.println("Printing document");
    }
}


public class Q5_SOLI {
}
