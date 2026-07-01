import org.junit.Test;
import org.junit.Assert;

public class AssertionsTest {
    
    @Test
    public void validateDifferentAssertions() {
        int expectedSum = 5;
        int actualSum = 2 + 3;
        Assert.assertEquals(expectedSum, actualSum);
        
        boolean isGreater = (5 > 3);
        Assert.assertTrue(isGreater);
        
        boolean isLess = (5 < 3);
        Assert.assertFalse(isLess);
        
        Object emptyObject = null;
        Assert.assertNull(emptyObject);
        
        Object validObject = new java.lang.Object();
        Assert.assertNotNull(validObject);
    }
}
