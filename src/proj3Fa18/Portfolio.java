package proj3Fa18;

import exceptionclasses.InvalidSaleException;
import queues.LinkedQueue;

public class Portfolio {
    private LinkedQueue<Stock> stocks;
    private SymbolTable symbols;
    private double gainLoss;


    public Portfolio (SymbolTable table) {
        symbols  = table;
        stocks   = new LinkedQueue<>();
        gainLoss = 0;
    }

    public void processTransaction(char transactionType, int amount, double price, String tickerSym) {
        if (transactionType == 'b') {
            stocks.enqueue(new Stock(amount, price, tickerSym));
        } else if (transactionType == 's') {
            Stock temp;
            int tempAmount = 0;
            for (int i = 0; i < stocks.size(); i++) {
                temp = stocks.dequeue();
                String formatPrice     = java.text.NumberFormat.getCurrencyInstance().format(price);
                String formatPurchased = java.text.NumberFormat.getCurrencyInstance().format(temp.getPurchasePrice());
                String compound        = java.text.NumberFormat.getCurrencyInstance().format((price - temp.getPurchasePrice()) * amount);
                if (temp.getTickerSymbol().equals(tickerSym) && temp.getSharesOwned() >= amount && amount != 0) {
                    gainLoss += (price - temp.getPurchasePrice()) * amount;
                    temp.setSharesOwned(temp.getSharesOwned() - amount);
                    System.out.println(amount + " stocks of " + symbols.findCompany(tickerSym) + " has been sold for "
                            + formatPrice + " originally purchased for " + formatPurchased);
                    if ((price - temp.getPurchasePrice()) > 0.00) {
                        System.out.println("The profit gained from the last transaction is: " + compound + "\n");
                    }
                    else { System.out.println("The loss from the last transaction is: " + compound + "\n"); }
                    amount = 0;
                }
                else if (temp.getTickerSymbol().equals(tickerSym) && temp.getSharesOwned() != 0 && temp.getSharesOwned() < amount) {
                    tempAmount = temp.getSharesOwned();
                    int salepotential = 0;
                    gainLoss += (price - temp.getPurchasePrice()) * tempAmount;
                    amount = amount - tempAmount;
                    System.out.println(tempAmount + " stocks of " + symbols.findCompany(tickerSym)
                            + " has been sold for " + formatPrice + " originally purchased for " + formatPurchased);
                    if ((price - temp.getPurchasePrice()) > 0.00) {
                        System.out.println("The profit gained from the last transaction is: " + compound + "\n");
                    }
                    else { System.out.println("The loss from the last transaction is: " + compound + "\n"); }
                    for (int j = 0; j < stocks.size(); j++) {
                        Stock temp2 = stocks.dequeue();
                        if (temp2.getTickerSymbol().equals(tickerSym)) {
                            salepotential += temp2.getSharesOwned();
                        }
                        stocks.enqueue(temp2);
                    }
                    if (salepotential > amount) {
                        temp.setSharesOwned(0);
                    }
                    else if (salepotential < amount) {
                        throw new InvalidSaleException("***Invalid Sale Exception*** We do not have enough stocks to sell: "
                                + symbols.findCompany(tickerSym) + "\n");
                    }
                }
                stocks.enqueue(temp);
            }
        }
    }


    public String toString() {
        String returnMe = "";
        String formatGainloss = java.text.NumberFormat.getCurrencyInstance().format(gainLoss);
        for (int i = 0; i < stocks.size(); i++) {
            Stock temp = stocks.dequeue();
            String formatPurchased = java.text.NumberFormat.getCurrencyInstance().format(temp.getPurchasePrice());
            if (temp.getSharesOwned() > 0) {
                returnMe += "\n" + symbols.findCompany(temp.getTickerSymbol()) + "\n" +
                        "Stocks in the inventory: " + temp.getSharesOwned() + "\n" +
                        "Purchased price: " + formatPurchased + "\n";
            }
            stocks.enqueue(temp);
        }
        returnMe += "\n" + "----------------------------------------" + "\n" +
                "Total profit of the portfolio: " + formatGainloss +
                "\n" + "----------------------------------------" + "\n";

        return returnMe;
    }
}
