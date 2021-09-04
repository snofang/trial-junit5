import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageProviderTest {

    @Test
    @DisplayName("get message test :~")
    void getMessage() {
//        System.out.println("not implemented yet but it is running ");
        Assertions.assertEquals("Hello from greeting!", new MessageProvider().getMessage());
    }

    /**
     * should not stop on one failure and continue on assertions all.
     */
    @Test
    void multipleAssertionSample(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        Assertions.assertAll(() -> Assertions.assertEquals(1, integers.get(0)),
                () -> Assertions.assertEquals(2, integers.get(1)),
                () -> Assertions.assertEquals(3, integers.get(2)),
                () -> Assertions.assertEquals(4, integers.get(3)),
                () -> Assertions.assertEquals(5, integers.get(4)));
    }

    /**
     * It is possible to have assumption on some tests
     */
    @Test
    void conditionalTest(){
        Assumptions.assumeTrue(2 > 4);
        System.out.println("this should not be seen/executed");
    }
}
