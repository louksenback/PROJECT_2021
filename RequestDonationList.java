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
    public void add(RequestDonation b, double quantity)
    {   
        if(rdEntities.contains(b))
        {
            modify(b, quantity);
        }
        else
        {
            rdEntities.add(b);
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
    public void modifyremove(RequestDonation d, double quantity)
    {
        d.removequantity(quantity);
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
            if(returnKlash(k) == "Material")
            {
                System.out.println((k+1) + ") " + rdEntities.get(k).getEntity().getName() + " " + "(" + rdEntities.get(k).getquantity() + ")");
            }
        }
    }
    public void listServices()
    {
        for(int k = 0; k<rdEntities.size(); k++)
        {
            if(returnKlash(k) == "Service")
            {
                System.out.println((k-2) + ") " + rdEntities.get(k).getEntity().getName() + " " + "(" + rdEntities.get(k).getquantity() + ")");
            }
        }
    }
    public void reset()
    {
        rdEntities.clear(); //ΕΕΕΕΕΕΕΕΕΕΕΕΕΕΕ?????????????????????? ΔΕΝ ΠΡΕΠΕΙ ΝΑ ΛΕΙΠΕΙ ΤΟ ΟΡΙΣΜΑ ΚΑΝΟΝΙΚΑ?
        System.out.println("Ola ta stoixeia ths listas diagrafhkan - afairethikan");
    }
    public String returnKlash(int i)
    {
        Entity a = rdEntities.get(i).getEntity();
        Class class1 = a.getClass();
        String klash = class1.getName();
        return klash;
    }
}