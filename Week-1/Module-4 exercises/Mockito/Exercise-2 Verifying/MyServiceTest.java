import org.junit.Test;
import org.mockito.Mockito;

public class MyServiceTest {
    
    @Test
    public void checkApiInteraction() {
        ExternalApi apiMock = Mockito.mock(ExternalApi.class);
        MyService mySvc = new MyService(apiMock);
        
        mySvc.fetchData();
        
        Mockito.verify(apiMock, Mockito.times(1)).getData();
    }
}
