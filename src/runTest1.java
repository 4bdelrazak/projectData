
import myDataStructure.*;
import myDataStructure.binarySearchTree;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class runTest1 {
    public static boolean isValidPassword(String password)
    {
        // Must have at least one numeric character
        //Must have at least one lowercase character
        //Must have at least one uppercase character
        //Must have at least one special symbol among @#$%
        //Password length should be between 8 and 20



        final String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public String name ;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW= "\u001B[33m";
    public static final String ANSI_Cyan="\u001B[36m";
    public static final String ANSI_GREEN ="\u001B[32m";



    // public static final String italic ="\033[3mText goes here\033[0m";
    public static void print(String s){
        System.out.println(ANSI_PURPLE+s);
    }

    linkedList listOfCustomers ;

    priorityQueue orders =new priorityQueue();

    binarySearchTree storeContent = new binarySearchTree("store");



    public void fillingOrder(){
        ArrayList<item> itemCusOne =  new ArrayList<>();
        item itemOneCus = storeContent.searchColor("Beige");
        itemCusOne.add(new item(itemOneCus.itemName,itemOneCus.itemPrice,itemOneCus.itemColors,3));
        item itemTwoCus = storeContent.searchColor("Lavender");
        itemCusOne.add(new item(itemTwoCus.itemName,itemTwoCus.itemPrice,itemTwoCus.itemColors,5));
        ArrayList<item> itemCusTWo =  new ArrayList<>();
        item itemThreeCus = storeContent.searchColor("maroon");
        itemCusTWo.add(new item(itemThreeCus.itemName,itemThreeCus.itemPrice,itemThreeCus.itemColors,12));
        item itemFourCus = storeContent.searchColor("off white");
        itemCusTWo.add(new item(itemFourCus.itemName,itemFourCus.itemPrice,itemFourCus.itemColors,4));
        order orderOne = new order(listOfCustomers.search(new node("Abed2003")).data,itemCusOne,"Abu samra");
        order orderTwo = new order(listOfCustomers.search(new node("Abed")).data,itemCusTWo,"Beirut");
        ArrayList<item> itemCusThree = new ArrayList<>();
        item itemFiveCus = storeContent.searchColor("Forest Green");
        itemCusThree.add(new item(itemFiveCus.itemName,itemFiveCus.itemPrice,itemFiveCus.itemColors,7));
        order orderThree = new order(listOfCustomers.search(new node("ahmad")).data,itemCusThree,"Mina");



        orders.enQueueWithP(orderOne);
        orders.enQueueWithP(orderTwo);
        orders.enQueue(orderThree);


        // orders.display();


    }




    public runTest1() throws InterruptedException, NoSuchAlgorithmException {
        listOfCustomers = new linkedList("customersList");
        fillingOrder();
        homePage();
    }


    public void homePage() throws NoSuchAlgorithmException, InterruptedException {




        //admin passWord Admin#123



        //listOfCustomers.insert("admin","adminPass#123");
        Scanner scan = new Scanner(System.in);
        boolean run = true ;
        int input =0 ;
        Boolean Error = true;
        String userName ;
        String passWord = "";

        linkedList.encryptor e = new linkedList.encryptor();
        print ( "\n" +
                "╦ ╦╔═╗╦  ╔═╗╔═╗╔╦╗╔═╗  ╔╦╗╔═╗  ╔═╗╦ ╦╦═╗  ╔═╗╔╦╗╔═╗╦═╗╔═╗\n" +
                "║║║║╣ ║  ║  ║ ║║║║║╣    ║ ║ ║  ║ ║║ ║╠╦╝  ╚═╗ ║ ║ ║╠╦╝║╣ \n" +
                "╚╩╝╚═╝╩═╝╚═╝╚═╝╩ ╩╚═╝   ╩ ╚═╝  ╚═╝╚═╝╩╚═  ╚═╝ ╩ ╚═╝╩╚═╚═╝\n \n         \n" +
                "           ╦  ╔═╗╔═╗╦ ╔╗╔  ╔═╗╔═╗\n" +
                "           ║  ║ ║║ ╦║ ║║║  ╠═╣╚═╗\n" +
                "           ╩═╝╚═╝╚═╝╩ ╝╚╝  ╩ ╩╚═╝\n \n \n" +
                "╔═╗╔╦╗╔╦╗╦╔╗╔  ╔═╗          ╔═╗╦ ╦╔═╗╔╦╗╔═╗╔╦╗╔═╗╦═╗  ╦\n" +
                "╠═╣ ║║║║║║║║║  ║ ║          ║  ║ ║╚═╗ ║ ║ ║║║║║╣ ╠╦╝  ║\n" +
                "╩ ╩═╩╝╩ ╩╩╝╚╝  ╚═╝          ╚═╝╚═╝╚═╝ ╩ ╚═╝╩ ╩╚═╝╩╚═  ╩\n");

        do {
            try {
                input = scan.nextInt();
                while (input > 1 || input < 0) {
                    System.out.println(ANSI_RED + "Invalid Input \n" + ANSI_PURPLE + "Please enter a valid answer : ");
                    input = scan.nextInt();
                }
                Error= false;
            } catch (InputMismatchException ex) {
                System.out.print("Your choice must be a number (integer)");
                scan.next();
            }
        }while(Error);

        if(input==0){

            Scanner scanthree = new Scanner(System.in);
            print("Please enter the admin Password :");
            passWord= scanthree.nextLine();                            //////////////////////////////////
            node adminUserName =listOfCustomers.checkIfDuplicate(new node("admin"));
            if(e.encryptString(passWord).equals(adminUserName.data.passWord)){
                //admin page
                adminHomePage();
            }
            else{
                while(!e.encryptString(passWord).equals(adminUserName.data.passWord)){
                    System.out.println(ANSI_RED+"INCORRECT PASSWORD"+ANSI_RESET);
                    print("Please re-enter your password");
                    passWord=passWordByUser();
                }
                adminHomePage();
            }
            //   if(passWord.equalsIgnoreCase(adminPassWord))
            //if the passWord  is correct show the managing window for the admin
            // adminWindow();
            //else System.out.println(ANSI+RED+"INCORRECT PASSWORD");
            //
        }
        if(input==1){
            // we have 3 diffrent cases
            // if the user does exist and the passWOrd is correct we need to show the store for the user
            //if the user does exist but the passWord is incorrect we simply print incorrectPassword and we give the option to reenter the password
            //if the user doesjt exist we give the option to register
            print("Are you a returning or new customer ?   (0/1)");

            int answer=0;
            Boolean error=true;
            do {
                try {
                    answer = scan.nextInt();
                    while (answer > 1 || answer < 0) {
                        System.out.println(ANSI_RED + "Invalid Input \n" + ANSI_PURPLE + "Please enter a valid answer : ");
                        answer = scan.nextInt();
                    }
                    error = false;
                } catch (InputMismatchException ex) {
                    System.out.print("Your choice must be a number (integer)");
                    scan.next();
                }
            }while(error);

            if(answer==1){
                Scanner inputString =new Scanner(System.in);
                print("Enter your username : ");
                userName = inputString.nextLine();
                print("Enter your password : ");
                Boolean err=true;
                do {
                    try {
                        passWord=inputString.nextLine();
                        while(!isValidPassword(passWord)){
                            System.out.println(ANSI_RED+"Invalid PassWord !"+ANSI_PURPLE+"\n Re-enter your password :");
                            passWord=inputString.nextLine();
                        }
                        err = false;
                    } catch (InputMismatchException ex) {
                        inputString.next();
                    }
                }while(err);

                // linkedList.encryptor e = new linkedList.encryptor();
                passWord = e.encryptString(passWord);
                listOfCustomers.insert(userName,passWord);
                print("Welcome to our store");
                name = userName;
                welcomepageCustomer();
            }
            if(answer==0){
                Scanner scanTwo = new Scanner(System.in);
                print("Please enter your Username :");
                userName=scanTwo.nextLine();
                node temp = listOfCustomers.checkIfDuplicate(new node(userName));// to find the node with the user name
                if(temp==null){
                    print("User not found. \nDo you want to register ?     (0/1)(No/Yes)");
                    answer = scan.nextInt();

                    if(answer==0)print("Thank you for visiting our store :)");
                    if(answer==1){listOfCustomers.insertByUser();
                        welcomepageCustomer();
                    }
                }
                if(temp!=null){
                    String correctPassWord = temp.data.passWord;
                    print("Please enter your password  :");
                    Boolean error2=true;
                    do {
                        try {
                            passWord= scanTwo.nextLine();
                            while(!correctPassWord.equals(e.encryptString(passWord))){
                                System.out.println(ANSI_RED+"INCORRECT PASSWORD"+ANSI_RESET);
                                print("Please re-enter your password");
                                passWord=passWordByUser();
                            }
                            error2 = false;
                        } catch (InputMismatchException ex) {
                            scanTwo.next();
                        }
                    }while(error2);


                    print("Welcome to our store");
                    name = userName;
                    //then we show the store content and stuff like that
                    //we pring a homepage like thing in the console
                    welcomepageCustomer();



                }
            }

        }
    }

    public String passWordByUser(){
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();

    }



    public  void welcomepageCustomer() throws NoSuchAlgorithmException, InterruptedException {
        int month = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue();
        int day = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getDayOfMonth();
        String p;

        if (listOfCustomers.checkIfDuplicate(new node(name)).data.plus)
            p = ANSI_YELLOW + "PREMIUM";
        else p = "NORMAL";
        System.out.println(ANSI_PURPLE + "WELCOME " + ANSI_RESET + ANSI_Cyan + "\033[3m" + name + " " + p + "\033[0m" + "         " + ANSI_Cyan + "1989/" + month + "/" + day);
        print("What would you like to do ? ");
        print("#1 Browse the store ");
        print("#2 Check on order");
        print("#3 Check Premium status");
        print("#4 Logout");
        Scanner scan = new Scanner(System.in);
        int answer = 0;
        Boolean error = true;
        do {
            try {
                answer = scan.nextInt();
                while (answer < 1 || answer > 4) {
                    System.out.println(ANSI_RED + "Invalid input !" + ANSI_RESET + "\nPlease enter a valid input");
                    answer = scan.nextInt();
                }
                error = false;
            } catch (InputMismatchException e) {
                System.out.print("Your choice must be a number (integer)");
                scan.next();
            }
        } while (error);


        if (answer == 1) {
            browseStorepage();
        }
        if (answer == 2) {
            boolean b = orders.displayOrder(name);
            if (!b) {
                System.out.println(ANSI_RED + "NO ORDER FOUND !");
            }
            welcomepageCustomer();
        }
        if (answer == 3) {
            int ans = 0;
            Scanner input = new Scanner(System.in);
            if (listOfCustomers.search(new node(name)).data.plus) {
                print("Would you like to un-subscribe ? ");

                Boolean Error = true;
                do {
                    try {
                        ans = input.nextInt();
                        while (ans < 0 || ans > 1) {
                            System.out.println(ANSI_RED + "Invalid input !" + ANSI_RESET + "\nPlease enter a valid input : ");
                            ans = input.nextInt();
                        }
                        Error = false;
                    } catch (InputMismatchException e) {
                        System.out.print("Your choice must be a number (integer)");
                        input.next();
                    }
                } while (Error);

                if (ans == 1) {
                    customer c = listOfCustomers.search(new node(name)).data;
                    c.plus = false;
                    welcomepageCustomer();
                }
                if (ans == 0) {
                    welcomepageCustomer();
                }

            }

            print("Would you like to subscribe ?      (0/1)");
            Boolean er = true;
            do {
                try {
                    ans = input.nextInt();
                    while (ans < 0 || ans > 1) {
                        System.out.println(ANSI_RED + "Invalid input !" + ANSI_RESET + "\nPlease enter a valid input : ");
                        ans = input.nextInt();
                    }
                    er = false;
                } catch (InputMismatchException e) {
                    System.out.print("Your choice must be a number (integer)");
                    input.next();
                }
            } while (er);

            if (ans == 1) {
                customer c = listOfCustomers.search(new node(name)).data;
                c.subscribe();
                listOfCustomers.update();
            }
            welcomepageCustomer();
        }
        if (answer == 4) {
            homePage();
        }
    }



    public void adminHomePage() throws NoSuchAlgorithmException, InterruptedException {
        //able to see avialible items and quanity and refill them
        //will be able to see order made by customers
        Scanner scan = new Scanner(System.in);
        int ans =0 ;
        print("What would you like to do ?");
        print("#1 Refill Stock ");// done
        print("#2 Add new color ");
        print("#3 Check on orders ");


        print("#4 Exit");

        Boolean Error = true;
        do {
            try {
                ans= scan.nextInt();
                while (ans < 1 || ans > 4) {
                    System.out.println(ANSI_RED + "Invalid input !" + ANSI_RESET + "\nPlease enter a valid input : ");
                    ans= scan.nextInt();
                }
                Error = false;
            } catch (InputMismatchException e) {
                System.out.print("Your choice must be a number (integer)");
                scan.next();
            }
        } while (Error);

        if(ans==1){
            refillPage();}
        if(ans==2){
            addingNewProductPage();
        }
        if(ans==3){
            orders.display();
            adminHomePage();
        }
        if(ans==4){
            homePage();
        }
    }

    private void refillPage() throws NoSuchAlgorithmException, InterruptedException {
        print("Products :");
        storeContent.quantityDisplay();
        refill();
        print("Products");
        storeContent.quantityDisplay();
//        print("Would you like  to refill more products    (0/1)");
//        Scanner scan = new Scanner(System.in);
//        int ans = scan.nextInt();
        int ans =0 ;
        Boolean errorr=true;
        do {
            Scanner scan  =new Scanner(System.in);
            print("Would you like to refill more products    (0/1)");
            do {
                try {
                    ans= scan.nextInt();
                    while (ans < 0 || ans > 1) {
                        System.out.println(ANSI_RED + "Invalid input !" + ANSI_RESET + "\nPlease enter a valid input : ");
                        ans= scan.nextInt();
                    }
                    errorr = false;
                } catch (InputMismatchException e) {
                    System.out.print("Your choice must be a number (integer)");
                    scan.next();
                }
            } while (errorr);

            if(ans==1){
                refill();
                print("Products");
                storeContent.quantityDisplay();}
        }while(ans==1);
        if(ans==0){
            adminHomePage();
        }

    }
    public void refill(){
        print("What product would you like to refill ");
        Scanner scan = new Scanner(System.in);
        binarySearchTree.treeNode product  =storeContent.searchColor(name);
        String name ="";
        Boolean error=true;
        do {
            try {
                name = scan.nextLine();
                while(product==null){
                    print(ANSI_RED+"product not found ! \n"+ANSI_PURPLE+"Please enter a valid product name");
                    name= scan.nextLine();
                    product  =storeContent.searchColor(name);
                }
                error = false;
            } catch (InputMismatchException e) {
                scan.next();
            }
        } while (error);


        print("How much would you like to add to this product "+product.itemColors +"(Quantity = "+product.itemQuantity+" )");
        Scanner input = new Scanner(System.in);
        int ans=0;
        Boolean Error=true;
        do {
            try {
                ans = input.nextInt();
                while (ans > 1000 || ans < 0) {
                    System.out.println(ANSI_RED + "Invalid input !" + ANSI_RESET + "\nPlease enter a valid input : ");
                    ans= input.nextInt();
                }
                Error = false;
            } catch (InputMismatchException e) {
                System.out.print("Your choice must be a number (integer)");
                input.next();
            }
        } while (Error);

        product.itemQuantity= product.itemQuantity+ans;
        storeContent.update();
    }

    public void addingNewProductPage() throws NoSuchAlgorithmException, InterruptedException {
        print("Products :");
        storeContent.quantityDisplay();
        addNewProduct();

        int ans = 0;
        Boolean Error = true;
        Scanner scan = new Scanner(System.in);
        do {
            print("Would you like to add more products ?    (0/1)");
            do {
                try {
                    ans = scan.nextInt();
                    while (ans > 1 || ans < 0) {
                        System.out.println(ANSI_RED + "Invalid input !" + ANSI_RESET + "\nPlease enter a valid input : ");
                        ans = scan.nextInt();
                    }
                    Error = false;
                } catch (InputMismatchException e) {
                    System.out.print("Your choice must be a number (integer)");
                    scan.next();
                }
            } while (Error);

            if (ans == 1) {
                addNewProduct();
            }
            if (ans == 0) {
                adminHomePage();
            }
        } while (ans == 1);

    }


    public void addNewProduct(){
        print("Please enter the name of the new color you wish to add :");
        Scanner StringInput = new Scanner(System.in);
        String newProduct []= new String[3];
        newProduct[0]=StringInput.nextLine();
        boolean found  = storeContent.ifNodeExits(newProduct[0]);
        if(found==true){
            storeContent.insert("","",newProduct[0],1);
        }
        else{
            print("product ID :");
            newProduct[1]=StringInput.nextLine();
            print("Price :");
            newProduct[2]=StringInput.nextLine();
            print("Quantity : ");
            Scanner intInput = new Scanner(System.in);
            int q = intInput.nextInt();
            storeContent.insert(newProduct[1],newProduct[2],newProduct[0],q);
        }
        print("Products :");
        storeContent.quantityDisplay();
    }



//    public void customerPage(){
//        print("Welcome to our store ! What do you wish to do ?");
//        print("#1 Browse the store ");
//        print("#2 Check on order");
//        print("#3 Subscribe  premium");
//        print("#4 exit ");
//        int  ans ;
//        Scanner scan  = new Scanner(System.in);
//        ans = scan.nextInt();
//        while(ans!=1&&ans!=2&&ans!=3&&ans!=4){
//            System.out.println(ANSI_RED+"Invalid input !"+ANSI_PURPLE+"\nPlease enter a valid input :");
//            ans= scan.nextInt();
//        }
//
//        if(ans==1){
//            browseStorepage();
//        }
//
//
//
//    }

    public void browseStorepage() throws NoSuchAlgorithmException, InterruptedException {
        print("How would you like to browse the store");
        print("#1 Normally ");
        print("#2 increasing price ");
        int ans =0 ;
        Boolean Error=true;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                ans = scan.nextInt();
                while (ans > 2 || ans < 1) {
                    System.out.println(ANSI_RED + "Invalid input !" + ANSI_RESET + "\nPlease enter a valid input : ");
                    ans= scan.nextInt();
                }
                Error = false;
            } catch (InputMismatchException e) {
                System.out.print("Your choice must be a number (integer)");
                scan.next();
            }
        } while (Error);


        if(ans==1){
            storeContent.randomDisplay();
            print("Would you like to buy some items ?   (0/1)");
            int a=0;
            Boolean er=true;
            do {
                try {
                    a = scan.nextInt();
                    while (a > 1 || a < 0) {
                        System.out.println(ANSI_RED + "Invalid input !" + ANSI_RESET + "\nPlease enter a valid input : ");
                        a = scan.nextInt();
                    }
                    er = false;
                } catch (InputMismatchException e) {
                    System.out.print("Your choice must be a number (integer)");
                    scan.next();
                }
            } while (er);

            if(a==1)buying();
            if(a==0)welcomepageCustomer();
        }
        if(ans==2){
            storeContent.customerDisplay();
            print("Would you like to buy some items ?   (0/1)");
            int a=0;
            Boolean error0=true;
            do {
                try {
                    a = scan.nextInt();
                    while (a > 1 || a < 0) {
                        System.out.println(ANSI_RED + "Invalid input !" + ANSI_RESET + "\nPlease enter a valid input : ");
                        a = scan.nextInt();
                    }
                    error0 = false;
                } catch (InputMismatchException e) {
                    System.out.print("Your choice must be a number (integer)");
                    scan.next();
                }
            } while (error0);

            if(a==1)buying();
            if(a==0)welcomepageCustomer();

            buying();
        }






    }

    public void buying() throws NoSuchAlgorithmException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        Scanner intScan = new Scanner(System.in);
        ArrayList<item> items = new ArrayList<item>();
        print("What is the color you want to buy ?");
        String item = "";
        Boolean error1 = true;
        do {
            try {
                item = scan.nextLine();
                while (!storeContent.ifNodeExits(item)) {
                    System.out.println("Not found, try again:");
                    item = scan.nextLine();
                }
                error1 = false;
            } catch (InputMismatchException e) {
                scan.next();
            }
        } while (error1);

        print("How many cans do you want of " + item);
        int q = 0;
        Boolean error = true;
        do {
            try {
                q = intScan.nextInt();
                while (q > storeContent.searchColor(item).itemQuantity) {
                    System.out.println(ANSI_RED + "Invalid Quantity" + ANSI_PURPLE + "\nplease enter a valid value :");
                    q = intScan.nextInt();
                }
                error = false;
            } catch (InputMismatchException e) {
                System.out.print("Your choice must be a number (integer)");
                intScan.next();
            }
        } while (error);

        item newItem = storeContent.searchColor(item);
        newItem.itemQuantity = newItem.itemQuantity - q;
        storeContent.update();
        items.add(new item(newItem.itemName, newItem.itemPrice, newItem.itemColors, q));
        int ans = 0;
        Boolean er = true;
        do {
            print("Would you like to buy more items ?   (0/1)");
            do {
                try {
                    ans = intScan.nextInt();
                    while (ans > 1 && ans < 0) {
                        System.out.println(ANSI_RED + "Invalid input !" + ANSI_PURPLE + "\nPlease enter a valid input :");
                        ans = intScan.nextInt();
                    }
                    er = false;
                } catch (InputMismatchException e) {
                    System.out.print("Your choice must be a number (integer)");
                    intScan.next();
                }
            } while (er);

            if (ans == 1) {
                Boolean err=true;
                print("What is the color you want to buy ?");
                do {
                    try {
                        item = scan.nextLine();
                        while (!storeContent.ifNodeExits(item)) {
                            System.out.println("Not found, try again: ");
                            item = scan.nextLine();
                        }
                        err = false;
                    } catch (InputMismatchException e) {
                        intScan.next();
                    }
                } while (err);

                print("How many cans do you want of " + item);
                Boolean Error = true;
                do {
                    try {
                        q = intScan.nextInt();
                        while (q > storeContent.searchColor(item).itemQuantity) {
                            System.out.println(ANSI_RED + "Invalid Quantity" + ANSI_PURPLE + "\nplease enter a valid value :");
                            q = intScan.nextInt();
                        }
                        Error = false;
                    } catch (InputMismatchException e) {
                        System.out.print("Your choice must be a number (integer)");
                        intScan.next();
                    }
                } while (Error);

                newItem = storeContent.searchColor(item);
                newItem.itemQuantity = newItem.itemQuantity - q;
                storeContent.update();
                items.add(new item(newItem.itemName, newItem.itemPrice, newItem.itemColors, q));

            }
            if (ans == 0) {

            }

        } while (ans == 1);

        print("Please enter your address : ");
        String add = scan.nextLine();


        order o = new order(listOfCustomers.search(new node(name)).data, items, add);
        if (listOfCustomers.search(new node(name)).data.plus) {
            orders.enQueueWithP(o);
            welcomepageCustomer();
        } else {
            orders.enQueue(o);
            welcomepageCustomer();
        }


    }







//    public void exitPage() throws InterruptedException {
//        String colors[]= {"\u001B[31m","\u001B[33m","\u001B[32m","\u001B[34m","\u001B[36m","\u001B[35m"};
//        int count = 0 ;
//            int counterMax = colors.length;
//    int delay = 200 , max =31 ;
//    print("Saving");
//        for (int i = 0; i <max ; i++) {
//            System.out.print(colors[count]+"*");
//            if(i%5==0)count++;
//            Thread.currentThread().sleep(delay);
//            if (count==counterMax)
//                count=0;
//        }
//        System.out.println("*"+ANSI_RESET);
//        System.out.println(colors[0]+"D"+colors[1]+"O"+colors[2]+"N"+colors[3]+"E"+colors[4]+"!");
//        for (int i = 0; i <5 ; i++) {
//            System.out.println();
//            Thread.currentThread().sleep(200);
//        }
//
//    }



    public runTest1 (String s){
        listOfCustomers = new linkedList("customersList");
        storeContent = new binarySearchTree("store");
        fillingOrder();
    }


}
