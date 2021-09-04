import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageProviderTest {

    @Test
    @DisplayName("get message test :~")
    void getMessage() {
//        System.out.println("not implemented yet but it is running ");
        Assertions.assertEquals("Hello from greeting!", new MessageProvider().getMessage());
    }
}
