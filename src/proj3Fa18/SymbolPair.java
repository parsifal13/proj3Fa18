package proj3Fa18;

/**
 * <p>Title: The SymbolPair Class </p>
 *
 * <p>Description: This class defines symbolPair which stores tickersym
 * and company name. This class also contains getters.</p>
 *
 * @author Hamin Choi
 */
public class SymbolPair {
    //  instance variables
    String tickerSym;
    String companyName;

    /**
     * parameterized constructor - initializes data to the user
     * specified value
     * @param ticker the value to be stored in variable tickerSym
     * @param name the value to be stored in variable companyName
     */
    public SymbolPair(String ticker, String name) {
        tickerSym = ticker;
        companyName = name;
    }

    /**
     * getTickerSymbol method - returns the value stored in instance variable tickerSym
     * @return a string data stored in tickerSym
     */
    public String getTickerSymbol() {
        return tickerSym;
    }

    /**
     * getCompanyName method - returns the value stored in instance variable getCompanyName
     * @return a string data stored in companyName
     */
    public String getCompanyName() {
        return companyName;
    }
}
