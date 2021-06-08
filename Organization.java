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
        return "\t\t\t\t\t" + name + "\n\t\t\t\t\t" + admin.getphone(); 
    }
    public void addEntity(Entity e) throws ExceptionOrganization
    {
        if(entityList.contains(e))
        {
            throw new ExceptionOrganization("Το είδος που εισήγατε υπάρχει ήδη στη λίστα!");
        }
        else
        {
            entityList.add(e);
        }
    }
    public void removeEntity(Entity f)
    {
        entityList.remove(f);
    }
    public void insertDonator(Donator g) throws ExceptionOrganization
    {
        if(entityList.contains(g))
        {
            throw new ExceptionOrganization("Ο δωρητής που εισήγατε υπάρχει ήδη στη λίστα!");
        }
        else
        {
            donatorList.add(g);
        }
    }
    public void removeDonator(Donator h)
    {
        donatorList.remove(h);
    }
    public void insertBeneficiary(Beneficiary i) throws ExceptionOrganization
    {
        if(entityList.contains(i))
        {
            throw new ExceptionOrganization("Ο επωφελούμενος που εισήγατε υπάρχει ήδη στη λίστα!");
        }
        else
        {
            beneficiaryList.add(i);
        }
    }
    public void removeBeneficiary (Beneficiary j)
    {
        beneficiaryList.remove(j);
    }
    public void listEntities()
    {
        System.out.println("Οι κατηγορίες των ειδών είναι: 1) Material, 2) Service");
        System.out.println("\n1. Material(s):");
        for(int k = 0; k < entityList.size(); k++)
        {
            if(returnClass(k) == "Material")
            {
                System.out.println(entityList.get(k).getName());
            }
        }
        System.out.println("\n2. Sevice(s):");
        for(int l = 0; l < entityList.size(); l++)
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
            System.out.println(beneficiaryList.get(l).getname() + " " + beneficiaryList.get(l).getphone());
        }
    }
    public void listDonators()
    {
        for(int m = 0; m<donatorList.size(); m++)
        {
            System.out.println(donatorList.get(m).getname() + " " + donatorList.get(m).getphone());
        }
    }
    public int returnbeneficiary(int phone)
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
    public int returnDonator(int phone)
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
    public String returnClass(int i)
    {
        Entity a = entityList.get(i);
        Class class1 = a.getClass();
        String klash = class1.getName();
        return klash;
    }
}