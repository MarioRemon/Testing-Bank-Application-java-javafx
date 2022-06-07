package sample;

public class Currency
{
    String Name;
    char logo;
    int equivalentAmountInEgypt;
    public Currency(String Name, char logo, int price)
    {
        this.Name = Name;
        this.logo = logo;
        this.equivalentAmountInEgypt = price;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public char getLogo() {
        return logo;
    }

    public void setLogo(char logo) {
        this.logo = logo;
    }

    public int getEquivalentAmountInEgypt() {
        return equivalentAmountInEgypt;
    }

    public void setEquivalentAmountInEgypt(int equivalentAmountInEgypt) {
        this.equivalentAmountInEgypt = equivalentAmountInEgypt;
    }
    public boolean BuyCurrency(String Name, int amount, int price)
    {
        if((amount * this.equivalentAmountInEgypt) <= price)
        {
            System.out.println("Successfully bought");
            return true;
        }return false;
    }




}
