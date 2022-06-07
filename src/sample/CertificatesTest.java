package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
class CertificatesTest {
    Client cl ;
    Certificates c;
    @BeforeEach
    public void init()
    {
        cl = new Client("Mario", "123");
         c = new Certificates(cl,"Mario",11, 19);
    }
    @Test
    void getName()
    {
        assertEquals("Mario", c.getName());
    }

    @Test
    void setName() {
        c.setName("Malak");
        assertEquals("Malak",c.Name);
    }

    @Test
    void getPercentage() {
        assertEquals(11, c.getPercentage());
    }

    @Test
    void setPercentage()
    {
        c.setPercentage(29);
        assertEquals(29, c.percentage);
    }
}