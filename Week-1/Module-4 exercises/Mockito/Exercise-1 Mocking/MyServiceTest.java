import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;

public class MyServiceTest {
    
    @Test
    public void validateExternalApiFetch() {
        ExternalApi simulatedApi = Mockito.mock(ExternalApi.class);
        String dummyResponse = "Mock Data";
        
        Mockito.when(simulatedApi.getData()).thenReturn(dummyResponse);
        
        MyService businessService = new MyService(simulatedApi);
        String actualResponse = businessService.fetchData();
        
        Assert.assertEquals(dummyResponse, actualResponse);
    }
}
