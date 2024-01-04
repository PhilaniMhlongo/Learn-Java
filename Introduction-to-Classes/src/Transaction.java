/**
 * Represents a transaction for transferring money between two accounts.
 */

public class Transaction 
{
	/**
     * Transfers the specified amount from one account to another.
     *
     * @param fromAccount The account from which money will be debited.
     * @param toAccount   The account to which money will be credited.
     * @param amount      The amount of money to be transferred.
     * @throws InsufficiebtFundsExceptions If the 'fromAccount' does not have sufficient funds.
     */
    public static void transferMoney(Account fromAccount, Account toAccount, Amount amount)
            throws InsufficiebtFundsExceptions 
            {
        synchronized (fromAccount) 
        {
            synchronized (toAccount) 
            {
                if (fromAccount.getBalance().getAmount().compareTo(amount.getAmount()) < 0) 
                {
                    throw new InsufficiebtFundsExceptions();
                } 
                else 
                {
                    fromAccount.debit(amount);
                    toAccount.credit(amount);
                }
            }
        }
    }

}
