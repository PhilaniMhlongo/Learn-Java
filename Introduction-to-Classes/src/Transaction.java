class Transaction 
{
	public static void transferMoney(Account fromAccount, Account toAccount, Amount amount)
            throws InsufficientFundsException 
            {
        synchronized (fromAccount) 
        {
            synchronized (toAccount) 
            {
                if (fromAccount.getBalance().getAmount().compareTo(amount.getAmount()) < 0) 
                {
                    throw new InsufficientFundsException();
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
