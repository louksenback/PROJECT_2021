public class Offers extends RequestDonationList
{
    //Methods
    public void commit(RequestDonationList RDL, Organization org)
    {
        for(int i = 0; i<1; i++)
        {
            org.currentDonations = RDL;
        }
        reset();
    }
    /*public void commitOne(RequestDonationList RDL, Organization org, int p)
    {
        RDL.rdEntities.add(rdEntities.get(p-1), rdEntities.get(p-1).getquantity());
        
    }*/
}