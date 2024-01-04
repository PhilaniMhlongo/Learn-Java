/**
 * Exception thrown when there are insufficient funds for a transaction.
 */

public class InsufficiebtFundsExceptions extends Exception
{
    /**
     * Constructs a new InsufficientFundsExceptions with a default message.
     */
   public InsufficiebtFundsExceptions() {
        super("Insufficient funds for the transaction.");
    }

    /**
     * Constructs a new InsufficientFundsExceptions with the specified message.
     *
     * @param message The detail message describing the exception.
     */
    public InsufficiebtFundsExceptions(String message) {
        super(message);
    }

    /**
     * Constructs a new InsufficientFundsExceptions with the specified message and cause.
     *
     * @param message The detail message describing the exception.
     * @param cause   The cause of the exception.
     */
    public InsufficiebtFundsExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new InsufficientFundsExceptions with the specified cause and a default message.
     *
     * @param cause The cause of the exception.
     */
    public InsufficiebtFundsExceptions(Throwable cause) {
        super("Insufficient funds for the transaction.", cause);
    }
}
