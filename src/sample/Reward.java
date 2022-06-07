package sample;

public class Reward {
    String Name;
    int price;

    int NumberOfAvailableOffer = 5;
    public Reward(String Name, int Price)
    {
        this.Name = Name;
        this.price = Price;
    }

    public Reward(String Name, int Price, int Number)
    {
        this(Name, Price);
        this.NumberOfAvailableOffer = Number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getNumberOfAvailableOffer() {
        return NumberOfAvailableOffer;
    }

    public void setNumberOfAvailableOffer(int numberOfAvailableOffer) {
        NumberOfAvailableOffer = numberOfAvailableOffer;
    }
    public Boolean RedeemOffer(int price)
    {
        if(price >= this.price)
        {
            this.NumberOfAvailableOffer--;
            return true;
        }
        return false;
    }
}
