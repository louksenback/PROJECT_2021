class Admin extends User
{
    private boolean isAdmin=true;
    
    //Constructor
    public Admin(String name, String phone)
    {
        super(name, phone);
    }
    public boolean getAdmin()
    {
        return isAdmin;
    }
}