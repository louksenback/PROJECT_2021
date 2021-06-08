import java.util.ArrayList;
class RequestDonationList
{
    ArrayList <RequestDonation> rdEntities = new ArrayList <RequestDonation>();
    
    //Constructor
    public RequestDonationList()
    {
        ArrayList <RequestDonation> rdEntities = new ArrayList <RequestDonation>();
        this.rdEntities = rdEntities;
    }
    
    //Methods
    public RequestDonation ReturnGet(int i)
    {
        return rdEntities.get(i);
    }
    public void get(int id)
    {
        for(int i = 0; i<rdEntities.size(); i++)
        {
            if(rdEntities.get(i).getEntity().getId() == id)
            {
                System.out.println(ReturnGet(i));
            }
        }
    }
    public void add(Organization org,RequestDonation b, double quantity)
    {
        int check = 0;
        for(int i = 0; i < rdEntities.size(); i++)
        {
            if(rdEntities.get(i).getEntity().getId() == b.getEntity().getId())
            {
                modify(rdEntities.get(i), quantity);
            }
            else
            {
                check++;
            }
        }
        if(check == rdEntities.size())
        {
            rdEntities.add(b);
                try
            {
                if(org.entityList.contains(b.getEntity()))
                {
                    throw new ExceptionOrganization("Το είδος που εισήγατε υπάρχει ήδη στη λίστα!");
                }
            }
            catch(ExceptionOrganization eo)
            {
                System.err.print(eo);
            }
        }
    }
    public void remove(RequestDonation c)
    {
        rdEntities.remove(c);
    }
    public void modify(RequestDonation d, double quantity)
    {
        d.addquantity(quantity);
    }
    public void monitor()
    {
        for(int i=0; i<rdEntities.size();i++)
        { 
            System.out.println(rdEntities.get(i).getEntity().getName() + " "+ "(" + rdEntities.get(i).getquantity() + ")");
        }
    }
    public void listMaterials()
    {
        for(int k = 0; k<rdEntities.size(); k++)
        {
            if(returnClass(k) == "Material")
            {
                System.out.println((k+1) + ") " + rdEntities.get(k).getEntity().getName() + " " + "(" + rdEntities.get(k).getquantity() + ")");
            }
        }
    }
    public void listServices()
    {
        for(int l = 0; l<rdEntities.size(); l++)
        {
            if(returnClass(l) == "Service")
            {
                System.out.println((l-2) + ") " + rdEntities.get(l).getEntity().getName() + " " + "(" + rdEntities.get(l).getquantity() + ")");
            }
        }
    }
    public void reset(RequestDonationList RDL)
    {
        rdEntities.clear();
        System.out.println("Όλα τα στοιχεία της λίστας αφαιρέθηκαν!");
    }
    public String returnClass(int i)
    {
        Entity a = rdEntities.get(i).getEntity();
        Class class1 = a.getClass();
        String klash = class1.getName();
        return klash;
    }
}