package sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
class ClientTest {
    Client c;
    Reward r;
    @BeforeEach
    public void init()
    {
        c = new Client("Mario", "123","0122884","Masr gdida",12,"a1",0,11, "a2", 12,0);

    }

    @Test
    void getName() {
        assertEquals("Mario", c.getName());
    }

    @Test
    void setName()
    {
        c.setName("Super");
        assertEquals("Super",c.Name);
    }

    @Test
    void getPassword() {
        assertEquals("123", c.getPassword());
    }

    @Test
    void setPassword() {
        c.setPassword("122");
        assertEquals("122",c.Password);
    }

    @Test
    void getPhoneNumber() {
        assertEquals("0122884",c.getPhoneNumber());
    }

    @Test
    void setPhoneNumber() {
        c.setPhoneNumber("321");
        assertEquals("321",c.PhoneNumber);
    }

    @Test
    void getAddress() {
        assertEquals("Masr gdida", c.Address);
    }

    @Test
    void setAddress() {
        c.setAddress("helio");
        assertEquals("helio", c.Address);
    }

    @Test
    void getAge() {
        assertEquals(12, c.getAge());
    }

    @Test
    void setAge() {
        c.setAge(13);
        assertEquals(13,c.Age);
    }



    @Test
    void seeMyAccountAmountStub1() {
        assertEquals(0, c.a1.amount);
        assertEquals(0, c.a1.getAmount());
        assertEquals(0, c.SeeMyAccountAmount(c.a1));
    }

    @Test
    void addMoneyToMyAccountStub2() {
        c.a2.increaseAccount(50);
        assertEquals(50, c.a2.amount);
        assertEquals(50, c.a2.getAmount());
        assertEquals(50, c.SeeMyAccountAmount(c.a2));
    }

    @Test
    void buyCertificatesStub3() {
        c.a1.increaseAccount(50);
        assertTrue(c.buyCertificates(c,"SH7ada",20,20));
        System.out.println(c.a1.amount);
        assertFalse(c.buyCertificates(c,"SH7ada",20,2000));
    }

    @Test
    void withdrawa1Stub4() {
        System.out.println(c.a1.amount);
        c.a1.increaseAccount(30);
     assertTrue(c.withdrawa1(20));

    }

    @Test
    void withdrawa2Stub5() {
        c.a2.increaseAccount(10);
        assertFalse(c.withdrawa2(20));
    }

    @Test
    void buyCurrencyStub6() {
        c.a1.increaseAccount(500);
        assertTrue(c.buyCurrency("SH7ada",20,1,'+'));
        assertFalse(c.buyCurrency("SH7ada",20,30,'+'));
    }
    @Test
    void getPointsStub7()
    {
        assertEquals(0,c.getPoints());
        c.points = 30;
        assertEquals(30,c.getPoints());
    }
    @Test
    void setPointsStub8()
    {
        c.setPoints(50);
        assertEquals(50,c.points);
    }

    @Test
    void getRewardsStub9() {
        assertFalse(c.getRewards("Addidas", 20));
        c.addPoint(40);
        assertTrue(c.getRewards("Addidas", 20));
    }
}