public class Material extends Entity
{
    double level1; // Posothta pou dikaioutai ena atomo
    double level2; // Posothta pou dikaiountai 2-4 atoma
    double level3; // Posothta pou dikaiountai 5 kai perissotera atoma
    
    //Constructor
    public Material(String Name, String description, int id)
    {
        super(Name, description, id);
        this.level1 = 3.0;
        this.level2 = 9.0;
        this.level3 = 15.0;
    }

    //Method
    
    public double getlevel(Beneficiary a)
    {
        if(a.getNoPersons() == 1)
        {
            return level1;
        }
        else if(a.getNoPersons() >= 2 && a.getNoPersons() <= 4)
        {
            return level2;
        }
        else if(a.getNoPersons() >= 5)
        {
            return level3;
        }
        else
        {
            //exception
            return 0.0;
        }
    }
    public String getDetails()
    {
        return "level1 = " + this.level1 + "\nlevel2 = " + this.level2 + "\nlevel3 = " + this.level3 + "\nTo antikeimeno " + getName() + " einai typou material.";
    }
}