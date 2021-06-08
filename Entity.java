public abstract class Entity
{
    private String Name;
    private String description;
    private int id;
    
    //Constructor
    public Entity(String Name, String description, int id)
    {
        this.Name = Name;
        this.description = description;
        this.id = id;
    }
    
    //Methods
    public String getEntityInfo()
    {
        return this.Name + " " + this.description + " " + this.id;
    }
    abstract String getDetails();
    public String toString()
    {
        return getEntityInfo() + getDetails();
    }
    public abstract double getlevel(Beneficiary b) throws ExceptionLevel;
    public int getId()
    {
        return this.id;
    }
    public String getName()
    {
        return this.Name;
    }
}