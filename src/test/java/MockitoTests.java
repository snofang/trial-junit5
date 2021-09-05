import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class MockitoTests {
    @Test
    void simpleMockitoTest(){
        ArrayList mockedList = mock(ArrayList.class);

        //stubbing method calls
        Mockito.when(mockedList.get(0)).thenReturn(1);
        Mockito.when(mockedList.get(1)).thenReturn(2);
        Mockito.when(mockedList.get(2)).thenThrow(new IllegalArgumentException());

        Assertions.assertEquals(1, mockedList.get(0));
        Assertions.assertEquals(2, mockedList.get(1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> mockedList.get(2));

        //interaction verification
        Mockito.verify(mockedList, times(1)).get(0);
        Mockito.verify(mockedList, times(1)).get(1);
        Mockito.verify(mockedList, times(1)).get(2);
    }
}
