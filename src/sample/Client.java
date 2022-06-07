package sample;

public class Client {
    String Name;
    String Password;
    String PhoneNumber;
    String Address;
    int Age;


    int points = 0;
    Account a1;
    Account a2;

    public Client(String Name, String Password) {
        this.Name = Name;
        this.Password = Password;
    }

    public Client(String Name, String Password, String a1Name, int secure1, String a2Name, int secure2) {
        this(Name, Password);
        a1 = new Account(a1Name, secure1);
        a2 = new Account(a2Name, secure2);
    }

    public Client(String Name, String Password, String PhoneNumber, String address, int age, String a1Name, int start1, int secure1, String a2Name, int secure2, int start2) {
        this(Name, Password, a1Name, secure1, a2Name, secure2);
        this.PhoneNumber = PhoneNumber;
        this.Address = address;
        this.Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public boolean getRewards(String Name, int price) {
        Reward r = new Reward(Name, price);
        if(r.RedeemOffer(this.points))
        {
            this.points -= price;
            return true;
        }
        return false;

    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    public int addPoint(int amount)
    {
        return(this.points += amount);
    }

    public int SeeMyAccountAmount(Account a) {
        return a.getAmount();
    }

    public boolean addMoneyToMyAccount(Account a, int amount) {
        return a.increaseAccount(amount);
    }

    public Boolean buyCertificates(Client buyer, String Name, double percentage, int amount) {
        if (amount > 0 && (amount < this.a1.amount || amount < this.a2.amount)) {
            Certificates c = new Certificates(buyer, Name, percentage, amount);
            return true;
        }
        return false;
    }

    public boolean withdrawa1(int amount) {
        return (this.a1.reduceAccount(amount));
    }

    public boolean withdrawa2(int amount) {
        return (this.a2.reduceAccount(amount));
    }

    public Boolean buyCurrency(String Name, int amount, int price, char logo) {
            Currency c1 = new Currency(Name, logo, price);
            return (c1.BuyCurrency(Name, amount, this.a1.getAmount()));

    }
}
