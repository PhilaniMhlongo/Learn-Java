import java.math.BigDecimal;
/**
 * Represents a monetary amount using a BigDecimal.
 * @author Philani Mhlongo
 */
public class Amount
{
  private BigDecimal amount;
  
  /**
     * Constructs a new Amount with the specified BigDecimal value.
     *
     * @param amount The value representing the monetary amount.
  */
  public Amount(BigDecimal amount)
  {
	this.amount=amount;
  }

  /**
     * Gets the BigDecimal value of the monetary amount.
     *
     * @return The BigDecimal value representing the monetary amount.
     */
  public BigDecimal getAmount()
  {
	return amount;
  }

}
