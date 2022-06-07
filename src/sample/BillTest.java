package sample;

import com.beust.ah.A;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
class BillTest {

    Bill b;
    Account a;
    @BeforeEach
    public void init()
    {
        b = new Bill("123","Kahraba", 250);
        a = new Account("Mario", 22, 500);
    }

    @Test
    void showBills() {
        assertEquals("The Bill to Kahraba and amount to be paid is 250", b.showBills());
    }

    @Test
    void getToBill() {
        assertEquals("Kahraba", b.getToBill());
    }

    @Test
    void setToBill() {
        b.setToBill("Maya");
        assertEquals("Maya", b.ToBill);
    }

    @Test
    void getAmountToBePaid() {
        assertEquals(250, b.getAmountToBePaid());
    }

    @Test
    void setAmountToBePaid() {
        b.setAmountToBePaid(200);
        assertEquals(200, b.amountToBePaid);
    }
    @Test
    void addToAmountToBePaid()
    {
        assertEquals(270,b.increaseAmountToBePaid(20));
    }

    @Test
    void payIntegratingAccountClass()
    {
        assertTrue(b.pay(a,100));
        assertEquals(150,b.amountToBePaid);
        assertEquals(400, a.amount);
        assertFalse(b.pay(a,600));
        assertEquals(150,b.amountToBePaid);
        assertEquals(400, a.amount);

    }
}