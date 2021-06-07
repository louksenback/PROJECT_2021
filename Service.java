public class Service extends Entity
{
    //Constructors
    public Service(String Name, String description, int id)
    {
        super(Name, description, id);
    }
    
    //Methods
    public String getDetails()
    {
        return "To antikeimeno " + getName() + " einai typou Service.";
    }
    public double getlevel(Beneficiary a)
    {
        return 0.0;
    }
}