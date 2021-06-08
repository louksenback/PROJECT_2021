public class Offers extends RequestDonationList
{
    //Methods
    public void commit(RequestDonationList RDL, Organization org, Donator o)
    {
        for(int i = 0; i < o.getoffersList().rdEntities.size(); i++)
        {
            RDL.add(org, o.getoffersList().rdEntities.get(i), o.getoffersList().rdEntities.get(i).getquantity());
        }
        org.currentDonations = o.getoffersList();
        o.getoffersList().rdEntities.clear();
    }
}