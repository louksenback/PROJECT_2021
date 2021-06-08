import java.util.*;
public class main
{
    public static void main(String []args)
    {
        Organization org = new Organization();
        RequestDonationList RDL = new RequestDonationList();
        Offers o = new Offers();
        Requests r = new Requests();
        Admin a = new Admin("Programmers", "123");
        org.setAdmin("Programmers", a);
        
        Material Milk = new Material("Γάλα", "Αγελαδίσιο Γάλα", 1826);
        Material Sugar = new Material("Ζάχαρη", "Λευκή κρυσταλική ζάχαρη", 1827);
        Material Rice = new Material("Ρύζι", "Ρύζι νυχάκι", 1828);
        
        Service MedicalSupport = new Service("MedicalSupport", "Δωρεάν αγορά φαρμάκων", 1628);
        Service NurserySupport = new Service("NurserySupport", "Επίσκεψη σε νοσοκομείο και δωρεάν περίθαλψη με παροχή κλίνης", 1629);
        Service BabySitting = new Service("BabySitting", "Φύλαξη του παιδιού(ων) για μία ημέρα", 1630);
        
        RequestDonation milk = new RequestDonation(Milk, 5);
        RequestDonation sugar = new RequestDonation(Sugar, 10);
        RequestDonation rice = new RequestDonation (Rice, 15);
        RequestDonation medicalSupport = new RequestDonation(MedicalSupport, 5);
        RequestDonation nurserySupport = new RequestDonation(NurserySupport, 10);
        RequestDonation babySitting = new RequestDonation(BabySitting, 15);
        RDL.rdEntities.add(milk);
        RDL.rdEntities.add(sugar);
        RDL.rdEntities.add(rice);
        RDL.rdEntities.add(medicalSupport);
        RDL.rdEntities.add(nurserySupport);
        RDL.rdEntities.add(babySitting);
        try
        {
            org.addEntity(Milk);
            org.addEntity(Sugar);
            org.addEntity(Rice);
            org.addEntity(MedicalSupport);
            org.addEntity(NurserySupport);
            org.addEntity(BabySitting);
        }
        catch(ExceptionOrganization O)
        {
            System.err.println(O);
        }
        
        Donator m = new Donator("Άλέξης", "1");
        Beneficiary k = new Beneficiary("Σάκης", "2");
        try
        {
            org.insertDonator(m);
        }
        catch(ExceptionOrganization p)
        {
            System.err.println(p);
        }
        try
        {
            org.insertBeneficiary(k);
        }
        
        catch (ExceptionOrganization l)
        {
            System.err.println(l);
        }
        
        Menu b = new Menu();
        b.checkuser(org, RDL, m, k, o, r);
    }
}