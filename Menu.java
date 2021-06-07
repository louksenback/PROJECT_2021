import java.util.Scanner;
public class Menu
{
    int p;
    public void checkuser(Organization org, RequestDonationList RDL, Donator d, Beneficiary b, Offers o)
    { 
        System.out.println("===================================================\n\n");
        System.out.println("Δώστε το κινητό σας τηλέφωνο: ");
        System.out.println("\n\n===================================================");
        Scanner a = new Scanner(System.in);
        p = a.nextInt();
        if(org.donatorPhone(p) == p)
        {
            org.returnDonator(p);
            Donator(org, RDL, d, b, o);
        }
        else if(org.beneficiaryphone(p) == p)
        {
            Beneficiary(org, RDL, d, b, o);
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
                        Beneficiary(org, RDL, d, b, o);
                        break;
                        //#posibol
                    case 2:
                        System.out.println("Δώστε το όνομά σας: ");
                        Scanner i = new Scanner(System.in);
                        String j = i.nextLine();
                        Donator l = new Donator(j, IntToString(p));
                        org.insertDonator(l);
                        Donator(org, RDL, d, b, o);
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
    public void Beneficiary(Organization org, RequestDonationList RDL, Donator d, Beneficiary b, Offers o) // ********************
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
        System.out.println("===================================================\n\n");
        System.out.println("1. Add Request\n\n2. Show Requests\n\n3. Commit\n\n4. Back\n\n5. Logout\n\n6. Exit\n\n");
        System.out.println("\n\n===================================================");
        System.out.print("Επιλέξτε μία ενέργεια από το μενού πατώντας τον αντίστοιχο αριθμο (1 - 6): ");
        switch(ScannerInt())
        {
            case 1:
                BC1(org, RDL, d, b, o);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
        }
        
    }
    public void Donator(Organization org, RequestDonationList RDL, Donator d, Beneficiary b, Offers o)
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
                DC1(org, RDL, d, b, o);
                break;
            case 2:
                DC2(org, RDL, d, b, o);
                break;
            case 3:
                DC3(org, RDL, d, b, o);
                break;
            case 4:
                DC4(org, RDL, d, b, o, 1);
                break;
            case 5:
                DC5(org, RDL, d, b, o);
                break;
            case 6:
                DC6();
                break;
        }
    }
    public void DC1(Organization org, RequestDonationList RDL, Donator d, Beneficiary b, Offers o)
    {
        org.listEntities();
        System.out.println("3. Back");
            switch(ScannerInt())
            {
                case 1: 
                    System.out.println("===================================================\n\n");
                    System.out.println("Material(s)\n\n");
                    RDL.listMaterials();
                    System.out.println("4. Back");
                    System.out.println("\n\n===================================================");
                    switch(ScannerInt())
                    {
                        case 1:
                            casesForDonator(org, RDL, d, b, o, 0);
                            break;
                            
                        case 2:
                            casesForDonator(org, RDL, d, b, o, 1);
                            break;
                            
                        case 3:
                            casesForDonator(org, RDL, d, b, o, 2);
                            break;
                        case 4:
                            DC4(org, RDL, d, b, o, 2);
                            break;
                        }
                    break;
                    
                case 2:
                    System.out.println("===================================================\n\n");
                    System.out.println("Service(s)\n\n");
                    RDL.listServices();
                    System.out.println("4. Back");
                    System.out.println("\n\n===================================================");
                    switch(ScannerInt())
                    {
                        case 1:
                            casesForDonator(org, RDL, d, b, o, 3);
                            break;
                            
                        case 2:
                            casesForDonator(org, RDL, d, b, o, 4);
                            break;
                            
                        case 3:
                            casesForDonator(org, RDL, d, b, o, 5);
                            break;
                            
                        case 4:
                            DC4(org, RDL, d, b, o, 2);
                            break;
                        }
                    break;
                    
                case 3:
                    DC4(org, RDL, d, b, o, 1);
                    break;
            }
    }
    public void DC2(Organization org, RequestDonationList RDL, Donator d, Beneficiary b, Offers o)
    {
        if(d.getoffersList().rdEntities.size() != 0)
            {
                System.out.println("Η λίστα με τα αντικείμενα που θέλετε να προσφέρετε είναι η εξής: ");
                o.monitor();
            }
            else
            {
                System.out.println("Δεν έχετε κάποιες προσφορές αυτή την στιγμή!");
                Donator(org, RDL, d, b, o);
            }
        int p = ScannerInt();
        switch((1 <= p && p <= 100) ? 1 : (101 <= p && p <= 10000) ? 2 : 3)
        {
            case 1:
                System.out.println("\n\n1. Διαγράψτε αυτή την παροχή σας! ");
                System.out.println("\n2. Τροποποιήστε την ποσότητα της παροχής σας!");
                System.out.println("\n3. Διαγράψτε όλες τις παροχές σας!");
                System.out.println("\n4. Καταχώρηση της δωρεάς σας!");
                System.out.println("\n5. Back");
                switch(ScannerInt())
                {
                    case 1:
                        d.remove(d.getoffersList().rdEntities.get(p-1));
                        Donator(org, RDL, d, b, o);
                        break;
                    case 2:
                        System.out.println("\nΟρίστε την ποσότητα που θέλετε να προσθέσετε ή να αφαιρέσετε κάνωντας χρήση του μείον (-)!");
                        double a = ScannerDouble();
                        System.out.println(a);
                        o.modify(d.getoffersList().rdEntities.get(p-1), a);
                        Donator(org, RDL, d, b, o);
                        break;
                    case 3:
                        d.reset();
                        Donator(org, RDL, d, b, o);
                        break;
                    case 4:
                        DC3(org, RDL, d, b, o);
                        break;
                    case 5:
                        DC4(org, RDL, d, b, o, 3);
                        break;
                }
                break;
        }
    }
    public void DC3(Organization org, RequestDonationList RDL, Donator d, Beneficiary b, Offers o)
    {
        o.commit(RDL, org, d);
        System.out.println("Η δωρεά σας κατοχυρώθηκε στον οργανισμό μας. Σας ευχαριστούμε θερμά!");
        Donator(org, RDL, d, b, o);
        RDL.monitor();
    }
    public void DC4(Organization org, RequestDonationList RDL, Donator d, Beneficiary b, Offers o, int a)
    {
        switch(a)
        {
            case 1:
                checkuser(org, RDL, d, b, o);
                break;
            case 2:
                DC1(org, RDL, d, b, o);
                break;
            case 3:
                DC2(org, RDL, d, b, o);
                break;
        }
    }
    public void DC5(Organization org, RequestDonationList RDL,  Donator d, Beneficiary b, Offers o)
    {
        checkuser(org, RDL, d, b, o);
    }
    public void DC6()
    {
        System.exit(0);
    }
    
    
    
    
    public void BC1(Organization org, RequestDonationList RDL, Donator d, Beneficiary b, Offers o)  // ADD REQUEST
    {
        org.listCurrentDonations();
        System.out.println("3. Back");
        switch(ScannerInt())
        {
            case 1: // ΕΔΩ ΕΧΕΙ ΕΠΙΛΕΓΕΙ Η ΚΑΤΗΓΟΡΙΑ MATERIALS
                System.out.println("===================================================\n\n");
                System.out.println("Material(s)\n\n");
                RDL.listMaterials();
                System.out.println("4. Back");
                System.out.println("\n\n==================================================="); 
                switch(ScannerInt())
                {
                    case 1: // ΕΠΙΛΟΓΗ ΠΡΩΤΟΥ MATERIAL
                        casesForBeneficiary(org, RDL, d, b, o, 0);
                        break;
                    case 2: // ΕΠΙΛΟΓΗ ΔΕΥΤΕΡΟΥ MATERIAL
                        casesForBeneficiary(org, RDL, d, b, o, 1);
                        break;
                    case 3: // ΕΠΙΛΟΓΗ ΤΡΙΤΟΥ MATERIAL
                        casesForBeneficiary(org, RDL, d, b, o, 2);
                        break;
                    case 4: // ΕΔΩ ΚΑΝΕΙ BACK.
                        break;
                }
            case 2: // ΕΔΩ ΕΧΕΙ ΕΠΙΛΕΓΕΙ Η ΚΑΤΗΓΟΡΙΑ SERVICES
                    System.out.println("===================================================\n\n");
                    System.out.println("Service(s)\n\n");
                    RDL.listServices();
                    System.out.println("4. Back");
                    System.out.println("\n\n===================================================");
                    switch(ScannerInt())
                    {
                        case 1:
                            casesForBeneficiary(org, RDL, d, b, o, 3);
                            break;
                        case 2:
                            casesForBeneficiary(org, RDL, d, b, o, 4);
                            break;
                        case 3:
                            casesForBeneficiary(org, RDL, d, b, o, 5);
                            break;
                        case 4: // ΕΔΩ ΚΑΝΕΙ BACK.
                            break;
                    }
        }
    }
    
    
    
    public void casesForBeneficiary(Organization org,RequestDonationList RDL , Donator d, Beneficiary b, Offers o, int i)
    {
        System.out.println(RDL.rdEntities.get(i).getEntity().getEntityInfo());
        System.out.println("Θέλετε να πάρετε αυτό το αγαθό; (y/n)");
        switch(ScannerChar())
        {
            case 'y':
                System.out.println("Πόση ποσότητα θέλετε να πάρετε;");
                b.add(b.getRequestsList().rdEntities.get(i), ScannerDouble());
                System.out.println("Η αίτησή σας προστέθηκε στην λίστα αιτήσεών σας. Μπορείτε να την δείτε και να την επεξεργαστείτε πατώντας το 2 και να την επικυρώσετε πατώντας το 3.");
                Beneficiary(org, RDL, d, b, o);
                break;
            case 'n':
                Beneficiary(org, RDL, d, b, o);
                break;
        }
    }
    
    
    public void casesForDonator(Organization org, RequestDonationList RDL, Donator d, Beneficiary b, Offers o, int i)
    {
        System.out.println(RDL.rdEntities.get(i).getEntity().getEntityInfo());
        System.out.println("Θέλετε να προσφέρετε αυτό το αγαθό; (y/n)");
        switch(ScannerChar())
        {
            case 'y':
                System.out.println("Πόση ποσότητα θέλετε να προσφέρετε;");
                d.add(RDL.rdEntities.get(i), ScannerDouble());
                System.out.println("Η προσφορά σας προστέθηκε στην λίστα σας, μπορείτε να την δείτε και να την επεξεργαστείτε πατώντας το 2 και να την επικυρώσετε πατώντας το 3!!!");
                Donator(org, RDL, d, b, o);
                break;
            case 'n':
                Donator(org, RDL, d, b, o);
                break;
        }
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