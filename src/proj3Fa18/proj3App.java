package proj3Fa18;

import exceptionclasses.InvalidSaleException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class proj3App {
    public static void main(String args[]) throws FileNotFoundException {
        SymbolTable theTable = new SymbolTable(new File("symboldata.txt"));
        Scanner stockdata = new Scanner(new File("stockdata.txt"));
        Portfolio Pf = new Portfolio(theTable);

        //  declaring variables for processing stockdata.txt
        char transactionType = ' ';
        int amount           = 0;
        double price         = 0;
        String tickersym     = "";
        boolean cont = true;

        //  processing stockdata.txt
        try {
            while (cont) {
                transactionType = stockdata.next().charAt(0);
                amount          = Integer.parseInt(stockdata.next());
                price           = Double.parseDouble(stockdata.next());
                tickersym       = stockdata.next();
                Pf.processTransaction(transactionType, amount, price, tickersym);
                if (!stockdata.hasNextLine()) {
                    break;
                }
            }
            stockdata.close();
        }
        catch (InvalidSaleException ex) {   // if selling amount is bigger than remaining stocks
            System.out.println(ex.getMessage());
            while (stockdata.hasNextLine()) {
                transactionType = stockdata.next().charAt(0);
                amount          = Integer.parseInt(stockdata.next());
                price           = Double.parseDouble(stockdata.next());
                tickersym       = stockdata.next();
                Pf.processTransaction(transactionType, amount, price, tickersym);
            }
            stockdata.close();
        }
        System.out.println("\n" + "Displaying remaining stocks in the inventory:" + "\n" + Pf.toString());
    }
}
