package exceptionclasses;

public class InvalidSaleException extends RuntimeException{
    public InvalidSaleException(String m) {
        super(m);
    }
}
