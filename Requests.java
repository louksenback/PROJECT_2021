import java.util.Scanner;

class Requests extends RequestDonationList
{
    
    //Methods
    public void check(RequestDonationList RDL, RequestDonation a, Beneficiary b, double quantity, int i) throws ExceptionRequests
    {
        b.setnoPersons();
        
        Class class1 = a.getEntity().getClass();
        String klash = class1.getName();
        if(klash == "Material")
        {
            if(a.getquantity() >= b.getRequestsList().rdEntities.get(i).getquantity() && (validRequestDonation(a, b, i) == 1))
            {
                add(RDL, a, quantity, b);
            }
            else
            {
                if((a.getquantity() <= b.getRequestsList().rdEntities.get(i).getquantity()) == false )
                {
                    throw new ExceptionRequests("Η πσοότητα που ζητάτε δεν είναι διαθέσιμη στον οργανισμό μας!");
                }
                else
                {
                    throw new ExceptionRequests("Η ποσότητα που ζητάτε δεν αντιστοιχεί στην ποσότητα που επιτρέπει το level σας να πάρετε!");
                }
            }
        }
        if(klash == "Service")
        {
            if(a.getquantity() >= b.getRequestsList().rdEntities.get(i).getquantity())
            {
                add(RDL, a, quantity, b);
            }
            else
            {
                throw new ExceptionRequests("Η πσοότητα που ζητάτε δεν είναι διαθέσιμη στον οργανισμό μας!");
            }
        }
    }
    public void add(RequestDonationList RDL, RequestDonation a, double quantity, Beneficiary b)
    {
        int check = 0;
        if(b.getReceivedList().rdEntities.size() > 0)
        {
            for(int i = 0; i <= b.getReceivedList().rdEntities.size(); i++)
            {
                if(b.getReceivedList().rdEntities.get(i).getEntity().getId() == RDL.rdEntities.get(i).getEntity().getId())
                {
                    modify(b.getReceivedList().rdEntities.get(i), quantity, b, i);
                }
                else
                {
                    check++;
                }
            }
            if(check == b.getReceivedList().rdEntities.size())
            {
                b.getReceivedList().rdEntities.add(a);
            }
        }
        else
        {
            b.getReceivedList().rdEntities.add(a);
        }
    }
    public void modify(RequestDonation a, double quantity, Beneficiary b, int i)
    {
        b.getReceivedList().rdEntities.get(i).addquantity(quantity);
    }
    public int validRequestDonation(RequestDonation b, Beneficiary c, int i)
    {
        Class class1 = b.getClass();
        String klash = class1.getName();
        try
        {
            if(c.getNoPersons() == 1)
            {
                if(c.calculation(b) + c.getRequestsList().rdEntities.get(i).getquantity() <= b.getEntity().getlevel(c))
                {
                    return 1;
                }
            }
            else if(c.getNoPersons() >= 2 && c.getNoPersons()<= 4)
            {
                if(c.calculation(b) + c.getRequestsList().rdEntities.get(i).getquantity() <= b.getEntity().getlevel(c))
                {
                    return 1;
                }
            }
            else if(c.getNoPersons() >= 5)
            {
                if(c.calculation(b) + c.getRequestsList().rdEntities.get(i).getquantity() <= b.getEntity().getlevel(c))
                {
                    return 1;
                }
            }
        }
        catch(ExceptionLevel a)
        {
            System.err.println(a);
        }
        return -1;
    }
    public void commit(RequestDonationList RDL, RequestDonation a, Beneficiary b, double quantity, int i)
    {
        try
        {
            check(RDL, a, b, quantity, i);
            System.out.println(RDL.rdEntities.size());
            for(int j = 0; j < RDL.rdEntities.size(); j++)
            {
                System.out.println("fffffffffff");
                if(b.getReceivedList().rdEntities.get(i).getEntity().getId() == RDL.rdEntities.get(j).getEntity().getId())
                {
                    System.out.println("iiiiiiiiii");
                    RDL.rdEntities.get(j).addquantity(-quantity);
                }
            }
            b.reset();
        }
        catch (ExceptionRequests er)
        {
            System.err.println(er);
        }
    }
}