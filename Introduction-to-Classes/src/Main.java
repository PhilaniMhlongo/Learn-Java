class Main
{

	public static void main(String[] args) 
	{
        // Create accounts
        Account account1 = new Account("123456", new Amount(new BigDecimal("1000.00")));
        Account account2 = new Account("789012", new Amount(new BigDecimal("500.00")));

        // Perform a money transfer
        try 
        {
            Transaction.transferMoney(account1, account2, new Amount(new BigDecimal("200.00")));
            System.out.println("Money transferred successfully!");
        } 
        catch (InsufficientFundsException e) 
        {
            System.out.println("Insufficient funds for the transfer.");
        }

        // Display account balances
        System.out.println("Account 1 balance: $" + account1.getBalance().getAmount());
        System.out.println("Account 2 balance: $" + account2.getBalance().getAmount());
    }
}

