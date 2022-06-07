package sample;

public class Certificates {
    Client owner;
    String Name;
    double percentage;
    int amount;
    public Certificates(Client buyer,String Name, double percentage, int amount)
    {
        this.owner = new Client(buyer.Name, buyer.Password);
        this.Name = Name;
        this.percentage = percentage;
        this.amount = amount;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
    public Client getOwner() {return owner;}
    public void setOwner(Client owner) {
        this.owner = owner;
    }
}
