import java.util.*;
public class Organization
{
    String name;
    Admin admin;
    RequestDonationList currentDonations;
    ArrayList <Entity> entityList = new ArrayList <Entity>();
    ArrayList <Donator> donatorList = new ArrayList <Donator>();
    ArrayList <Beneficiary> beneficiaryList = new ArrayList <Beneficiary>();
    
    //Methods
    public void setAdmin(String name, Admin admin)
    {
        this. name = name;
        this.admin = admin;
    }
    public String getAdmin()
    {
        return "\t\t\t\t\t" + admin + "\n\t\t\t\t\t" + name; 
    }
    public void addEntity(Entity e)
    {
        entityList.add(e);
        //exception 
    }
    void removeEntity(Entity f)
    {
        entityList.remove(f);
    }
    public void insertDonator(Donator g)
    {
        donatorList.add(g);
        //exception
    }
    public void removeDonator(Donator h)
    {
        donatorList.remove(h);
    }
    public void insertBeneficiary(Beneficiary i)
    {
        beneficiaryList.add(i);
         //exception
    }
    public void removeBeneficiary (Beneficiary j)
    {
        beneficiaryList.remove(j);
    }
    public void listEntities()
    {
        System.out.println("Oi kathgories twn entity einai: 1) Material, 2) Service");
        System.out.println("\n1. Material(s):");
        for(int k = 0; k<entityList.size(); k++)
        {
            if(returnClass(k) == "Material")
            {
                System.out.println(entityList.get(k).getName());
            }
        }
        System.out.println("\n2. Sevice(s):");
        for(int l = 0; l<entityList.size(); l++)
        {
            if(returnClass(l) == "Service")
            {
                System.out.println(entityList.get(l).getName());
            }
        }
    }
    public void listBeneficiaries()
    {
        for(int l = 0; l<beneficiaryList.size(); l++)
        {
            System.out.println(beneficiaryList.get(l));
        }
    }
    public void listDonators()
    {
        for(int m = 0; m<donatorList.size(); m++)
        {
            System.out.println(donatorList.get(m));
        }
    }
    public int donatorPhone(int phone)
    {
        for(int i = 0; i < donatorList.size(); i++)
        {
            int j = Integer.parseInt(donatorList.get(i).getphone());
            if(j == phone)
            {
                return phone;
            }
        }
        return 0;
    }
    public int beneficiaryphone(int phone)
    {
        for(int i = 0; i < beneficiaryList.size(); i++)
        {
            int j = Integer.parseInt(beneficiaryList.get(i).getphone());
            if(j == phone)
            {
                return phone;
            }
        }
        return 0;
    }
    public Donator returnDonator(int phone)
    {
        for(int i = 0; i < donatorList.size(); i++)
        {
            int j = Integer.parseInt(donatorList.get(i).getphone());
            if(j == phone)
            {
                return donatorList.get(i);
            }
        }
        return donatorList.get(0); //exception
    }
    public String returnClass(int i)
    {
        Entity a = entityList.get(i);
        Class class1 = a.getClass();
        String klash = class1.getName();
        return klash;
    }
}