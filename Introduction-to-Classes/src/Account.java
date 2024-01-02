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

	public synchronized void debit(Amount money) throws InsufficientFundsExeptions
	{
		if (balance.getAmount().compareTo(money.getAmount()) <0)
		{
			throw new InsufficientFundsException();
		}

		balance =new Amount(balance.getAmount().subtract(amount.getAmount()));
	}

	public synchronized void credit(Amount amount)
	{
		balance = new Amount(balance.getAmount().add(amount.getAmount()));
	}

}
