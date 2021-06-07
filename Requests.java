import java.util.Scanner;

class Requests extends RequestDonationList
{
    private double input = 0.0;
    
    //Methods
    public void check(RequestDonation a, Beneficiary b)
    {
        b.setnoPersons();
        System.out.println("Eisagetai mia posothta: ");
        Scanner s = new Scanner(System.in);
        input = s.nextInt();
        
        Class class1 = a.getEntity().getClass();
        String klash = class1.getName();
        if(klash == "Material")
        {
            if(a.getquantity() >= input && (validRequestDonation(a, b) == 1))
            {
                 modify(a, input, b);
                 a.removequantity(input);
            }
            else
            {
                if((a.getquantity() <= input) == false )
                {
                    //exception
                }
                else
                {
                    //exception
                }
            }
        }
        if(klash == "Service")
        {
            if(a.getquantity() >= input)
            {
                modify(a, input, b);
                a.removequantity(input);
            }
            else
            {
                //exception
            }
        }
    }
    public void add(RequestDonation a, double quantity, Beneficiary b)
    {
        b.getReceivedList().add(a, quantity);
    }
    public void modify(RequestDonation a, double quantity, Beneficiary b)
    {
        if(b.getReceivedList().rdEntities.contains(a))
        {
            modify(a, quantity);
        }
        else
        {
            add(a, quantity, b);
        }
    }
    public int validRequestDonation(RequestDonation b, Beneficiary c) //exceptions gia tis if mesa stis if mesa stis if
    {
        Class class1 = b.getClass();
        String klash = class1.getName();
        if(c.getNoPersons() == 1)
        {
            if(c.calculation(b) + input <= b.getEntity().getlevel(c))
            {
                return 1;
            }
        }
        else if(c.getNoPersons() >= 2 && c.getNoPersons()<= 4)
        {
            if(c.calculation(b) + input <= b.getEntity().getlevel(c))
            {
                return 1;
            }
        }
        else if(c.getNoPersons() >= 5)
        {
            if(c.calculation(b) + input <= b.getEntity().getlevel(c))
            {
                return 1;
            }
        }
        return -1; //exception
    }
    public void commit(RequestDonation a, Beneficiary b, Double quantity)
    {
        check(a, b); //Estw oti epityxoun oi elegxoi
    }
}