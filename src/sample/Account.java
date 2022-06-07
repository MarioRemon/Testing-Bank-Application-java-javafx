package sample;

public class Account
{
    String Name;
    int SecurityNumber;
    int amount;
    public Account(String Name)
    {
        this.Name = Name;
    }
    public Account(String Name, int SecurityNumber)
    {
        this.Name = Name;
        this.SecurityNumber = SecurityNumber;
    }
    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Account(String Name, int SecurityNumber, int amount)
    {
        this(Name, SecurityNumber);
        this.amount = amount;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSecurityNumber() {
        return SecurityNumber;
    }

    public void setSecurityNumber(int securityNumber) {
        SecurityNumber = securityNumber;
    }
    public boolean reduceAccount(int amount)
    {
        if(amount < this.amount)
        {
            this.amount -= amount;
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean increaseAccount(int amount)
    {
            this.amount += amount;
            return true;
    }
    public void transferAccount(Account ToAccount, int Amount)
    {
        this.amount -= Amount;
        ToAccount.amount  += Amount;
    }
}
