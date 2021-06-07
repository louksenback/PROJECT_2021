import java.util.Comparator;

public class RequestDonation implements Comparator <Entity>
{
    private Entity entity;
    private double quantity;
    
    //Constructor
    public RequestDonation(Entity entity, double quantity)
    {
        this.entity = entity;
        this.quantity = quantity;
    }
    
    //Methods
    public Entity getEntity()
    {
        return this.entity;
    }
    public void addquantity(double quantity)
    {
        this.quantity += quantity;
    }
    public void removequantity(double quantity)
    {
        this.quantity -= quantity;
    }
    public double getquantity()
    {
        return this.quantity;
    }
    public int compare(Entity a, Entity b)
    {
        return Integer.compare(a.getId(), b.getId());
    }
    public void setquantity(double quantity)
    {
        this.quantity = quantity;
    }
}