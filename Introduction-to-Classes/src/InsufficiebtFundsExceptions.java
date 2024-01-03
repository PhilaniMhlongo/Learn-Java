class InsufficiebtFundsExceptions extends Exception
{
   public InsufficiebtFundsExceptions() {
        super("Insufficient funds for the transaction.");
    }

    public InsufficiebtFundsExceptions(String message) {
        super(message);
    }

    public InsufficiebtFundsExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficiebtFundsExceptions(Throwable cause) {
        super("Insufficient funds for the transaction.", cause);
    }
}
