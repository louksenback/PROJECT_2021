import java.util.*;
public class main
{
    public static void main(String []args)
    {
        Organization org = new Organization();
        RequestDonationList RDL = new RequestDonationList();
        Offers o = new Offers();
        
        Material Milk = new Material("Μilk", "ufyfguw", 1826);
        Material Sugar = new Material("Sugar", "hgagagra", 1827);
        Material Rice = new Material("Rice", "eqtffWF", 1828);
        
        Service MedicalSupport = new Service("MedicalSupport", "vfgwgfy", 1628);
        Service NurserySupport = new Service("NurserySupport", "gaegae", 1629);
        Service BabySitting = new Service("BabySitting", "gwdfwyu", 1630);
        
        RequestDonation milk = new RequestDonation(Milk, 5);
        RequestDonation sugar = new RequestDonation(Sugar, 10);
        RequestDonation rice = new RequestDonation (Rice, 15);
        RequestDonation medicalSupport = new RequestDonation(MedicalSupport, 5);
        RequestDonation nurserySupport = new RequestDonation(NurserySupport, 10);
        RequestDonation babySitting = new RequestDonation(BabySitting, 15);
        RDL.add(milk, 0);
        RDL.add(sugar, 0);
        RDL.add(rice, 0);
        RDL.add(medicalSupport, 0);
        RDL.add(nurserySupport, 0);
        RDL.add(babySitting, 0);
        
        org.addEntity(Milk);
        org.addEntity(Sugar);
        org.addEntity(Rice);
        org.addEntity(MedicalSupport);
        org.addEntity(NurserySupport);
        org.addEntity(BabySitting);
        
        Donator m = new Donator("Nikos", "1");
        Beneficiary k = new Beneficiary("Giorgos", "11");
        org.insertDonator(m);
        org.insertBeneficiary(k);
        
        Menu b = new Menu();
        b.checkuser(org, RDL, m, o);
        
        /*Material Milk = new Material("Μilk", "ufyfguw", 1826);
        Service MedicalSupport = new Service("MedicalSupport", "vfgwgfy", 1628);
        System.out.println(Milk.getDetails());
        System.out.println(MedicalSupport.getDetails());
        RequestDonation milk = new RequestDonation(Milk, 5);
        RequestDonation medicalSupport = new RequestDonation(MedicalSupport, 10);
        RDL.add(milk, 5);
        RDL.monitor();
        RDL.add(milk, 5);
        RDL.add(medicalSupport, 10);
        RDL.get(1826);
        RDL.get(1628);
        RDL.monitor();
        RDL.modify(milk, 3.0);
        RDL.modify(medicalSupport, 11.0);
        RDL.monitor();
        //RDL.reset();
        //RDL.monitor();
        
        
        org.addEntity(Milk);
        org.addEntity(MedicalSupport);
        org.listEntities();
        System.out.println(RDL.rdEntities);
        
        o.commit(RDL, org);
        RDL.monitor();
        
        Donator a = new Donator("makhs", "epsi epsi triantaepsi");
        a.add(milk, 30);
        o.commit(RDL, org);
        a.commit(o);
        a.monitor();
        //o.commit(RDL, org);
        a.reset();
        a.monitor();
        
        Beneficiary k = new Beneficiary("Girgos","4945567674");
        
        Requests d = new Requests();
        d.check(medicalSupport, k);
        RDL.monitor();*/
    }
}