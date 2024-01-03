class Account
{
	private String accountNumber;
	private Amount balance;

	public Account(String accountNumber, Amount initialBalance)
	{
		this.accountNumber=accountNumber;
		this.balance=initialBalance;

	}

	public String getAccountNumber()
	{
		return this.accountNumber;
	}

	public Amount getBalance()
	{
		return balance;
	}

	public synchronized void debit(Amount money) throws InsufficiebtFundsExceptions
	{
		if (balance.getAmount().compareTo(money.getAmount()) <0)
		{
			throw new InsufficiebtFundsExceptions();
		}

		balance =new Amount(balance.getAmount().subtract(money.getAmount()));
	}

	public synchronized void credit(Amount money)
	{
		balance = new Amount(balance.getAmount().add(money.getAmount()));
	}

}
