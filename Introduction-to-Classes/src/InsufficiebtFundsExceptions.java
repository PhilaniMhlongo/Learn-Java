class InsufficientFundsExceptions extends Exceptions
{
   public InsufficientFundsException() {
        super("Insufficient funds for the transaction.");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }

    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficientFundsException(Throwable cause) {
        super("Insufficient funds for the transaction.", cause);
    }
}
