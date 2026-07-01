import org.junit.Test;
import org.junit.Assert;

public class SimpleTest {

    @Test
    public void verifyMathLogic() {
        int valA = 3;
        int valB = 7;
        Assert.assertEquals(10, valA + valB);
    }

    @Test
    public void checkStringValue() {
        String msg = "Hello JUnit";
        Assert.assertNotNull(msg);
    }

    @Test
    public void validateBooleanCondition() {
        boolean flag = true;
        Assert.assertTrue(flag);
    }
}
