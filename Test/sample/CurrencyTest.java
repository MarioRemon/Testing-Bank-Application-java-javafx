package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
class CurrencyTest {
    Currency c;
    @BeforeEach
    public void init()
    {
        c = new Currency("Dollar",'$', 2);
    }

    @Test
    void getName() {
        assertEquals("Dollar", c.getName());
    }

    @Test
    void setName() {
        c.setName("EGP");
        assertEquals("EGP",c.Name);
    }

    @Test
    void getLogo() {
        assertEquals('$',c.logo);
    }

    @Test
    void setLogo() {
        c.setLogo('#');
        assertEquals('#',c.logo);
    }

    @Test
    void getEquivalentAmountInEgypt() {
        assertEquals(2,c.equivalentAmountInEgypt);
    }

    @Test
    void setEquivalentAmountInEgypt() {
        c.setEquivalentAmountInEgypt(3);
        assertEquals(3,c.equivalentAmountInEgypt);
    }

    @Test
    void buyCurrency() {
        assertTrue(c.BuyCurrency("Dollar",3,10));
    }
}