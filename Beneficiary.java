import java.util.Scanner;
import java.util.ArrayList;

public class Beneficiary extends User
{
    private int noPersons = 1;
    private RequestDonationList receivedList;
    private Requests requestsList;

    //Constructor
    public Beneficiary(String name, String phone)
    {
        super(name, phone);
        RequestDonationList receivedList = new RequestDonationList();
        this.receivedList = receivedList;
        Requests requestsList = new Requests();
        this.requestsList = requestsList;
    }

    //Methods
    public void setnoPersons()
    {
        System.out.println("Δώσε τον αριθμό των ατόμων: ");
        Scanner s = new Scanner(System.in);
        noPersons = s.nextInt();
        if(noPersons == 1)
        {
            System.out.println("Eiste level 1.");
        }
        else if(noPersons >= 2 && noPersons<= 4)
        {
            System.out.println("Eiste level 2.");
        }
        else if(noPersons >= 5)
        {
            System.out.println("Eiste level 3.");
        }
    }
    public int getNoPersons()
    {
        return noPersons;
    }
    public RequestDonationList getReceivedList()
    {
        return receivedList;
    }
    public Requests getRequestsList()
    {
        return requestsList;
    }
    public void add(RequestDonation a, double quantity)
    {
        RequestDonation p = new RequestDonation(a.getEntity(), quantity);
        requestsList.rdEntities.add(p);
    }
    public void modify(RequestDonation s, double quantity)
    {
        if(requestsList.rdEntities.contains(s))
        {
            s.addquantity(quantity);
        } 
        else
        {
            requestsList.rdEntities.add(s);
        }
    }
    public void removeRequestsList(RequestDonation c)
    {
        requestsList.rdEntities.remove(c);
    }
    public void reset()
    {
        requestsList.rdEntities.clear();
    }
    public void monitorRequestsList()
    {
        for(int i=0; i < requestsList.rdEntities.size();i++)
        { 
            System.out.println(requestsList.rdEntities.get(i).getEntity().getName() + " "+ "(" + requestsList.rdEntities.get(i).getquantity() + ")");
        }
    }
    public double calculation(RequestDonation a)
    {
        int check = 0;
        for(int i = 0; i < getReceivedList().rdEntities.size(); i++)
        {
            if(receivedList.rdEntities.contains(a))
            {
                return getReceivedList().rdEntities.get(i).getquantity();
            }
        }
        return 0.0;
    }
}