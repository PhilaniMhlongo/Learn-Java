import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CalculatorTest
{
	Calculator calculator = new Calculator();

	@Test
	public void testAdditionPositive()
	{
		assertEquals(5,calculator.Addition(2,3));
	}

	@Test
	public void testAdditionNegative()
	{
		assertNotEquals(6,calculator.Addition(2,3));
	}
}
