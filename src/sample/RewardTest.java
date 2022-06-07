package sample;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import static org.junit.jupiter.api.Assertions.*;

class RewardTest {
    Reward r;
    @BeforeEach
    public void init()
    {
        r = new Reward("Mario", 100, 5);
    }
    @Test
    void getName() {
        assertEquals("Mario", r.getName());
    }

    @Test
    void setName() {
        r.setName("Malak");
        assertEquals("Malak" , r.Name);
    }

    @Test
    void getPrice() {
        assertEquals(100,r.price);
    }

    @Test
    void setPrice() {
        r.setPrice(90);
        assertEquals(90,r.price);
    }

    @Test
    void getNumberOfAvailableOffer() {
        assertEquals(5,r.getNumberOfAvailableOffer());
    }

    @Test
    void setNumberOfAvailableOffer() {
        r.setNumberOfAvailableOffer(6);
        assertEquals(6,r.NumberOfAvailableOffer);
    }

    @Test
    void redeemOffer() {
        assertTrue(r.RedeemOffer(110));
        assertEquals(4,r.NumberOfAvailableOffer);
    }
}