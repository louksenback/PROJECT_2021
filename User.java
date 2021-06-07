abstract class User
{
    private String name;
    private String phone;
    
    //Constractor
    public User(String name, String phone)
    {
        this.name = name;
        this.phone = phone;
    }
    public String getphone()
    {
        return this.phone;
    }
    public String getname()
    {
        return this.name;
    }
}