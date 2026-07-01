import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;

public class CalculatorTest {

    private Calculator calcInstance;

    @Before
    public void initializeTest() {
        calcInstance = new Calculator();
    }

    @Test
    public void checkAdditionLogic() {
        int num1 = 15;
        int num2 = 20;
        int output = calcInstance.add(num1, num2);
        Assert.assertEquals(35, output);
    }

    @Test
    public void checkSubtractionLogic() {
        int a = 50;
        int b = 15;
        int diff = calcInstance.subtract(a, b);
        Assert.assertEquals(35, diff);
    }

    @After
    public void cleanupTest() {
        calcInstance = null;
    }
}
