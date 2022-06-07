package sample;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
class AccountTest {
    Account a ;
    @BeforeEach
    public void init() {
        a = new Account("Mario", 22, 20);
    }

    @Test
    void testGetAmount() {
        assertEquals(20,a.getAmount());
    }

    @Test
    void setAmount() {
        a.setAmount(21);
        assertEquals(21,a.amount);
    }

    @Test
    void getName() {
        assertEquals("Mario", a.getName());
    }

    @Test
    void setName() {
        a.setName("Malak");
        assertEquals("Malak",a.Name);
    }

    @Test
    void getSecurityNumber() {
        assertEquals(22, a.SecurityNumber);
    }

    @Test
    void setSecurityNumber() {
        a.setSecurityNumber(23);
        assertEquals(23, a.SecurityNumber);
    }

    @Test
    void reduceAccount() {
        assertTrue(a.reduceAccount(15));
        assertFalse(a.reduceAccount(50));
    }

    @Test
    void increaseAccount() {
        a.increaseAccount(15);
        assertEquals(35,a.amount);
    }

    @Test
    void transferAccount() {
        Account a2 = new Account("Super", 25, 1000);
        a.transferAccount(a2,2);
        assertEquals(18,a.amount);
        assertEquals(1002,a2.amount);
    }
}