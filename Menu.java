import java.util.Scanner;
public class Menu
{
    int p;
    public void checkuser(Organization org, RequestDonationList RDL, Donator o, Offers k)
    { 
        System.out.println("===================================================\n\n");
        System.out.println("Δώστε το κινητό σας τηλέφωνο: ");
        System.out.println("\n\n===================================================");
        Scanner a = new Scanner(System.in);
        p = a.nextInt();
        if(org.donatorPhone(p) == p)
        {
            org.returnDonator(p);
            Donator(org, RDL, o, k);
        }
        else if(org.beneficiaryphone(p) == p)
        {
            Beneficiary(org, RDL);
        }
        else if(org.getAdmin() == "true")
        {
            System.out.println("Είστε ο Διαχειριστής!");
        }
        else
        {
            System.out.println("Θέλετε να εγγραφείτε; (y/n)");
            if(ScannerChar() == 'y')
            {
                System.out.println("Θέλετε να εγγραφείτε ως επωφελούμενος ή ως δωρητής");
                System.out.println("1. Επωφελούμενος \n2. Δωρητής");
                switch(ScannerInt())
                {
                    case 1:
                        System.out.print("Δώστε το όνομά σας: ");
                        Scanner f = new Scanner(System.in);
                        String g = f.nextLine();
                        Beneficiary h = new Beneficiary(g, IntToString(p));
                        org.insertBeneficiary(h);
                        Beneficiary(org, RDL);
                        break;
                        //#posibol
                    case 2:
                        System.out.println("Δώστε το όνομά σας: ");
                        Scanner i = new Scanner(System.in);
                        String j = i.nextLine();
                        Donator l = new Donator(j, IntToString(p));
                        org.insertDonator(l);
                        Donator(org, RDL, o, k);
                        break;
                        //#posibol
                    }
                }
            if(ScannerChar() == 'n')
            {
                System.out.println("Αντίο");
                System.exit(0);
            }
        }
    }
    public void Beneficiary(Organization org, RequestDonationList RDL)
    {
        System.out.println("===================================================");
        System.out.println("\t  Organization: Make it possible!\n\n");//onoma organismou
        System.out.println("\t\tΚαλώς ορίσατε!\n\n");
        System.out.println(org.getAdmin());
        for(int i = 0; i < org.beneficiaryList.size(); i++)
        {
            if(StringToInt(org.beneficiaryList.get(i).getphone()) == p)
            {
                System.out.println(org.beneficiaryList.get(i).getname() + "\n" + org.beneficiaryList.get(i).getphone() + "\n\n");
            }
        }
    }
    public void Donator(Organization org, RequestDonationList RDL, Donator o, Offers k)
    {
        System.out.println("===================================================");
        System.out.println("\t  Organization: Make it possible!\n\n");//onoma organismou
        System.out.println("\t\tΚαλώς ορίσατε!\n\n");
        System.out.println(org.getAdmin());
        for(int i = 0; i < org.donatorList.size(); i++)
        {
            if(StringToInt(org.donatorList.get(i).getphone()) == p)
            {
                System.out.println(org.donatorList.get(i).getname() + "\n" + org.donatorList.get(i).getphone() + "\n\n");
            }
        }
        System.out.println("===================================================\n\n");
        System.out.println("1. Add Offer\n\n2. Show Offers\n\n3. Commit\n\n4. Back\n\n5. Logout\n\n6. Exit\n\n");
        System.out.println("\n\n===================================================");
        System.out.print("Επιλέξτε μία ενέργεια από το μενού πατώντας τον αντίστοιχο αριθμο (1 - 6): ");
        switch(ScannerInt())
        {
            case 1:
                DC1(org, RDL, o, k);
                break;
            case 2:
                DC2(org, RDL, o, k);
                break;
            case 3:
                DC3(org, RDL, o , k);
                break;
        }
    }
    public void DC1(Organization org, RequestDonationList RDL, Donator o, Offers k)
    {
        org.listEntities();
            switch(ScannerInt())
            {
                case 1:
                    System.out.println("===================================================\n\n");
                    System.out.println("Material(s)\n\n");
                    RDL.listMaterials();
                    System.out.println("\n\n===================================================");
                    switch(ScannerInt())
                    {
                        case 1:
                            System.out.println(RDL.rdEntities.get(0).getEntity().getEntityInfo());
                            System.out.println("Θέλετε να προσφέρετε αυτό το αγαθό; (y/n)");
                            switch(ScannerChar())
                            {
                                case 'y':
                                    System.out.println("Πόση ποσότητα θέλετε να προσφέρετε;");
                                    o.add(RDL.rdEntities.get(0), ScannerDouble());
                                    System.out.println("Η προσφορά σας προστέθηκε στην λίστα σας, μπορείτε να την δείτε και να την επεξεργαστείτε πατώντας το 2 και να την επικυρώσετε πατώντας το 3!!!");
                                    Donator(org, RDL, o, k);
                                    break;
                                case 'n':
                                    Donator(org, RDL, o, k);
                                    break;
                            }
                            break;
                            
                        case 2:
                            System.out.println(RDL.rdEntities.get(1).getEntity().getEntityInfo());
                            System.out.println("Θέλετε να προσφέρετε αυτό το αγαθό; (y/n)");
                             switch(ScannerChar())
                            {
                                case 'y':
                                    System.out.println("Πόση ποσότητα θέλετε να προσφέρετε;");
                                    o.add(RDL.rdEntities.get(1), ScannerDouble());
                                    System.out.println("Η προσφορά σας προστέθηκε στην λίστα σας, μπορείτε να την δείτε και να την επεξεργαστείτε πατώντας το 2 και να την επικυρώσετε πατώντας το 3!!!");
                                    Donator(org, RDL, o, k);
                                    break;
                                case 'n':
                                    Donator(org, RDL, o, k);
                                    break;
                            }
                            break;
                            
                        case 3:
                            System.out.println(RDL.rdEntities.get(2).getEntity().getEntityInfo());
                            System.out.println("Θέλετε να προσφέρετε αυτό το αγαθό; (y/n)");
                             switch(ScannerChar())
                            {
                                case 'y':
                                    System.out.println("Πόση ποσότητα θέλετε να προσφέρετε;");
                                    o.add(RDL.rdEntities.get(2), ScannerDouble());
                                    System.out.println("Η προσφορά σας προστέθηκε στην λίστα σας, μπορείτε να την δείτε και να την επεξεργαστείτε πατώντας το 2 και να την επικυρώσετε πατώντας το 3!!!");
                                    Donator(org, RDL, o, k);
                                    break;
                                case 'n':
                                    Donator(org, RDL, o, k);
                                    break;
                            }
                            break;
                        }
                    break;
                    
                case 2:
                    System.out.println("===================================================\n\n");
                    System.out.println("Service(s)\n\n");
                    RDL.listServices();
                    System.out.println("\n\n===================================================");
                    switch(ScannerInt())
                    {
                        case 1:
                            System.out.println(RDL.rdEntities.get(3).getEntity().getEntityInfo());
                            System.out.println("Θέλετε να προσφέρετε αυτό το αγαθό; (y/n)");
                            switch(ScannerChar())
                            {
                                case 'y':
                                    System.out.println("Πόση ποσότητα θέλετε να προσφέρετε;");
                                    o.add(RDL.rdEntities.get(3), ScannerDouble());
                                    System.out.println("Η προσφορά σας προστέθηκε στην λίστα σας, μπορείτε να την δείτε και να την επεξεργαστείτε πατώντας το 2 και να την επικυρώσετε πατώντας το 3!!!");
                                    Donator(org, RDL, o, k);
                                    break;
                                case 'n':
                                    Donator(org, RDL, o, k);
                                    break;
                            }
                            break;
                            
                        case 2:
                            System.out.println(RDL.rdEntities.get(4).getEntity().getEntityInfo());
                            System.out.println("Θέλετε να προσφέρετε αυτό το αγαθό; (y/n)");
                             switch(ScannerChar())
                            {
                                case 'y':
                                    System.out.println("Πόση ποσότητα θέλετε να προσφέρετε;");
                                    o.add(RDL.rdEntities.get(4), ScannerDouble());
                                    System.out.println("Η προσφορά σας προστέθηκε στην λίστα σας, μπορείτε να την δείτε και να την επεξεργαστείτε πατώντας το 2 και να την επικυρώσετε πατώντας το 3!!!!");
                                    Donator(org, RDL, o, k);
                                    break;
                                case 'n':
                                    Donator(org, RDL, o, k);
                                    break;
                            }
                            break;
                            
                        case 3:
                            System.out.println(RDL.rdEntities.get(5).getEntity().getEntityInfo());
                            System.out.println("Θέλετε να προσφέρετε αυτό το αγαθό; (y/n)");
                             switch(ScannerChar())
                            {
                                case 'y':
                                    System.out.println("Πόση ποσότητα θέλετε να προσφέρετε;");
                                    o.add(RDL.rdEntities.get(5), ScannerDouble());
                                    System.out.println("Η προσφορά σας προστέθηκε στην λίστα σας, μπορείτε να την δείτε και να την επεξεργαστείτε πατώντας το 2 και να την επικυρώσετε πατώντας το 3!!!");
                                    Donator(org, RDL, o, k);
                                    break;
                                case 'n':
                                    Donator(org, RDL, o, k);
                                    break;
                            }
                            break;
                        }
                    break;
                }
    }
    public void DC2(Organization org, RequestDonationList RDL, Donator o, Offers k)
    {
        if(o.getoffersList().rdEntities.size() != 0)
            {
                System.out.println("Η λίστα με τα αντικείμενα που θέλετε να προσφέρετε είναι η εξής: ");
                o.monitor();
            }
            else
            {
                System.out.println("Δεν έχετε κάποιες προσφορές αυτή την στιγμή!");
                Donator(org, RDL, o, k);
            }
        int p = ScannerInt();
        switch((1 <= p && p <= 100) ? 1 : (101 <= p && p <= 10000) ? 2 : 3)
        {
            case 1:
                System.out.println("\n\n1. Διαγράψτε αυτή την παροχή σας! ");
                System.out.println("\n2. Τροποποιήστε την ποσότητα της παροχής σας!");
                System.out.println("\n3. Διαγράψτε όλες τις παροχές σας!");
                System.out.println("\n4. Καταχώρηση της δωρεάς σας!");
                switch(ScannerInt())
                {
                    case 1:
                        o.remove(o.getoffersList().rdEntities.get(p-1));
                        Donator(org, RDL, o, k);
                        break;
                    case 2:
                        System.out.println("\nΟρίστε την ποσότητα που θέλετε να προσθέσετε ή να αφαιρέσετε κάνωντας χρήση του μείον (-)!");
                        double a = ScannerDouble();
                        System.out.println(a);
                        o.modify(o.getoffersList().rdEntities.get(p-1), a);
                        Donator(org, RDL, o, k);
                        break;
                    case 3:
                        o.reset();
                        Donator(org, RDL, o, k);
                        break;
                    case 4:
                        RDL.add(o.getoffersList().rdEntities.get(p-1), o.getoffersList().rdEntities.get(p-1).getquantity());
                        RDL.monitor();
                        o.remove(o.getoffersList().rdEntities.get(p-1));
                        Donator(org, RDL, o, k);
                        break;
                }
                break;
        }
    }
    public void DC3(Organization org, RequestDonationList RDL, Donator o, Offers k)
    {
        k.commit(RDL, org);
        Donator(org, RDL, o, k);
    }
    public int ScannerInt()
    {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        return b;
    }
    public char ScannerChar()
    {
        Scanner a = new Scanner(System.in);
        char b = a.next().charAt(0);
        return b;
    }
    public double ScannerDouble()
    {
        Scanner a = new Scanner(System.in);
        double b = a.nextDouble();
        return b;
    }
    public String IntToString(int p)
    {
        String s = Integer.toString(p);
        System.out.println(s);
        return s;
    }
    public int StringToInt(String p)
    {
        int j = Integer.parseInt(p);
        return j;
    }
}