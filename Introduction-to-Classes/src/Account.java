/**
 * Represents a bank account with an account number and balance.
 */
public class Account
{
	private String accountNumber;
	private Amount balance;
	/**
     * Constructs a new Account with the specified account number and initial balance.
     *
     * @param accountNumber  The unique identifier for the account.
     * @param initialBalance The initial balance of the account.
     */
	public Account(String accountNumber, Amount initialBalance)
	{
		this.accountNumber=accountNumber;
		this.balance=initialBalance;

	}

	/**
     * Gets the account number associated with this account.
     *
     * @return The account number.
     */
	public String getAccountNumber()
	{
		return this.accountNumber;
	}

	/**
     * Gets the current balance of the account.
     *
     * @return The balance.
     */
	public Amount getBalance()
	{
		return balance;
	}

	/**
     * Debits the specified amount from the account.
     *
     * @param money The amount to be debited.
     * @throws InsufficiebtFundsExceptions If the account does not have sufficient funds.
     */
	public synchronized void debit(Amount money) throws InsufficiebtFundsExceptions
	{
		if (balance.getAmount().compareTo(money.getAmount()) <0)
		{
			throw new InsufficiebtFundsExceptions();
		}

		balance =new Amount(balance.getAmount().subtract(money.getAmount()));
	}

	/**
     * Credits the specified amount to the account.
     *
     * @param money The amount to be credited.
     */
	public synchronized void credit(Amount money)
	{
		balance = new Amount(balance.getAmount().add(money.getAmount()));
	}

}
