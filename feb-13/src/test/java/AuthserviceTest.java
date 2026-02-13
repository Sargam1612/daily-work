import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unitTestingPractice.AuthService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthserviceTest {
    AuthService authService;
    @Test
    void testValidUserName(){
        boolean result = authService.login("Sargam","123");
        assertEquals(false,result);
    }

    @BeforeEach
    void setup(){
        authService = new AuthService();
    }
}
