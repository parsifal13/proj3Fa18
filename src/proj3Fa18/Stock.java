package proj3Fa18;

/**
 * <p>Title: The Stock Class </p>
 *
 * <p>Description: This class defines a stock data to be stored in the Linkedlist.
 * it also has methods to get ticker symbol, amount of shares owned and
 * purchased price along with mutator method to set number of shares owned
 * the toString method in this class is only used for testing. </p>
 *
 * @author Hamin Choi
 */
public class Stock {
    //  instance variables
    private String tickerSym;
    private int sharesOwned;
    private double purchasePrice;

    /**
     * parameterized constructor - accepts amount of shares, prices and
     * tickersymbol and instantiate the object with those parameters.
     * @param shares amount of stock
     * @param prices price of the stock
     * @param sym represents company name in abbreviated form
     */
    public Stock(int shares, double prices, String sym) {
        tickerSym = sym;
        sharesOwned = shares;
        purchasePrice = prices;
    }

    /**
     * getTickerSymbol method - returns the value stored in instance variable tickerSym
     * @return a string data stored in tickerSym
     */
    public String getTickerSymbol() {
        return tickerSym;
    }

    /**
     * getSharesOwned method - returns the value stored in instance variable sharesOwned
     * @return an int data stored in sharesOwned
     */
    public int getSharesOwned() {
        return sharesOwned;
    }

    /**
     * getPurchasedPrice method - returns the value stored in instance variable purchasePrice
     * @return an int data stored in purchasePrice
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * setSharesOwned method - this method is mutator method for variable sharesOwned
     * @param newNum a new number to be setted as sharesOwned
     */
    public void setSharesOwned(int newNum) {
        sharesOwned = newNum;
    }

    /**
     * toString method - returns a string data that represents current state of each stock
     * this toString method is only for the code testing
     * @return a string data represents current state of each stock
     */
    public String toString() {
        String returnMe;
        returnMe = tickerSym + " " + sharesOwned + " " + purchasePrice;
        return returnMe;
    }
}

