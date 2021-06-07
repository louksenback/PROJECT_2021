public class Donator extends User
{
    private Offers offersList;
    
    //Constructor
    public Donator(String name, String phone)
    {
        super(name, phone);
        Offers offersList = new Offers();
        this.offersList = offersList;
    }
    
    //Methods
    public void add(RequestDonation a, double quantity)
    {
        RequestDonation p = new RequestDonation(a.getEntity(), quantity);
        offersList.rdEntities.add(p);
    }
    public void remove(RequestDonation w)
    {
        offersList.rdEntities.remove(w);
    }
    public void commit(Offers o)
    {
        o.rdEntities = offersList.rdEntities;
    }
    public void modify(RequestDonation s, double quantity)
    {
        if(offersList.rdEntities.contains(s))
        {
            s.addquantity(quantity);
        } 
        else
        {
            offersList.rdEntities.add(s);
        }
    }
    public void monitor()
    {
        for(int i = 0; i<offersList.rdEntities.size(); i++)
        {
            System.out.println((i+1) + ") " + offersList.rdEntities.get(i).getEntity().getName() + "(" + offersList.rdEntities.get(i).getquantity() + ")");
        }
    }  
    public void reset()
    {
        offersList.rdEntities.clear();
    }
    public Offers getoffersList()
    {
        return offersList;
    }
}