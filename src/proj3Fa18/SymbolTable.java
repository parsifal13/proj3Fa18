package proj3Fa18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import queues.LinkedQueue;

public class SymbolTable {
    //  instance variable
    private LinkedQueue<SymbolPair> symbolPairs = new LinkedQueue<>();

    /**
     * parameterized constructor - this constructor accepts a txt file to scan.
     * once the file has accepted, automatically scan it and creates an SymbolTable object
     */
    public SymbolTable(File SymbolTable) throws FileNotFoundException {
        //  local variables
        String tickerSym;
        String companyName;
        Scanner fileScan = new Scanner(SymbolTable);
        while (fileScan.hasNextLine()) {  // enqueue imported data
            tickerSym   = fileScan.next();
            companyName = fileScan.nextLine();
            companyName = companyName.substring(1);
            symbolPairs.enqueue(new SymbolPair(tickerSym, companyName));
        }
        fileScan.close();
    }

    /**
     * findCompany method - returns full company name by accepting ticker symbol from parameter
     * @param sym a string data from the user
     * @return a string data stored in companyName
     */
    public String findCompany(String sym) {
        SymbolPair temp;
        String returnMe = "";
            for (int i = 0; i < symbolPairs.size(); i++) {
                temp = symbolPairs.dequeue();
                if (temp.getTickerSymbol().equals(sym)) {
                    returnMe = temp.getCompanyName();
                }
                symbolPairs.enqueue(temp);
            }
        return returnMe;
    }
}


