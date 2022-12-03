package myDataStructure;


import java.io.*;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class binarySearchTree {
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RED = "\u001B[31m";
    //option to display according to price
    //to be able to display the categories based on price ascending
    //descending easily
    //other option  is to display randomly
    //idea we give a random integer as an attribute to each node
    //then we display them according to those ints

    public class treeNode extends item {
        public treeNode left;
        public treeNode right ;
        treeNode(String itemName,String itemPrice,String itemColors,int itemQuantity){
            this.itemName=itemName;
            this.itemPrice=itemPrice;
            this.itemColors=itemColors;
            this.itemQuantity=itemQuantity;
        }

        public String goodDisplay(){
            return "Name : "+itemColors +" Quantity : "+itemQuantity;
        }

//test changes



    }
    public treeNode root ;
    String sourceFile;


    public binarySearchTree(String sourceFile){
        this.sourceFile =sourceFile;
        // load();
        root=null;
    }
    boolean isEmpty(){
        return root==null;
    }
    treeNode insertHelper(treeNode root,String n,String p , String c,int q){

        if(root==null){
            root = new treeNode(n,p,c,q);
            return root ;}
        if(Double.parseDouble(p)<Double.parseDouble(root.itemPrice)){
            root.left=insertHelper(root.left,n,p,c,q);
        }
        if(Double.parseDouble(p)>=Double.parseDouble(root.itemPrice)){
            root.right=insertHelper(root.right, n, p, c,q);
        }
//        if(Double.parseDouble(p)==Double.parseDouble(root.itemPrice)){
//
//            double b=Double.parseDouble(p)-0.01;
//            String newP = b+"";
//            root.left = insertHelper(root.left,n,newP,c);
//        }
        return root ;


    }

    public void insert(String n ,String p,String c,int q ){
        if(isEmpty())
            load();
        if (ifNodeExits(c)){
            Scanner input = new Scanner(System.in);
            treeNode node = searchColor(c);
            System.out.println(ANSI_PURPLE+"The Color already exits "+node.itemColors+" Price : "+node.itemPrice+"$"+",Do you want to edit its price ?    (0/1)");
            int answer = 0;
            Boolean Error = true;
            do {
                try {
                    answer = input.nextInt();
                    while(answer<0 || answer>1){
                        System.out.println(ANSI_RED+"Invalid Input! \n"+ANSI_PURPLE+"Please enter a valid input : ");
                        answer=input.nextInt();
                    }
                    Error = false;
                } catch (InputMismatchException e) {
                    System.out.print("Your choice must be a number (integer)");
                    input.next();
                }
            } while (Error);

            if(answer==1){
                //Scanner inputTwo = new Scanner(System.in);
                System.out.println("Please enter the new price");
                double newPrice = 0;
                Boolean error = true;
                do {
                    try {
                        newPrice = input.nextDouble();
                        while(newPrice<0 || newPrice>1000){
                            System.out.println(ANSI_RED+"Invalid Price! \n"+ANSI_PURPLE+"Please enter a valid price : ");
                            newPrice = input.nextDouble();
                        }
                        error = false;
                    } catch (InputMismatchException e) {
                        System.out.print("Your choice must be a number");
                        input.next();
                    }
                } while (error);

                node.itemPrice= newPrice+"";
                System.out.println("The new price of "+node.itemColors+" is "+node.itemPrice+"$");
                update();
            }

            return;
        }
        insertItem(n,p,c,q);
        update();
    }
    void insertItem(String n,String p,String c,int q){

        root=insertHelper(root,n,p,c,q);

    }
    //
    public void increasingOrderDisplay(){
        if(isEmpty())load();
        increasingOrderDisplayHelper(root);
    }
    void increasingOrderDisplayHelper(treeNode root){

        //PreOrder Traversal = Root Left Right
        if(root!=null){
            increasingOrderDisplayHelper(root.left);
            System.out.println(root.toString() + " ");
            increasingOrderDisplayHelper(root.right);

        }
    }
    public void quantityDisplay(){
        if(isEmpty())load();
        quantityDisplayHelper(root);
    }
    public void quantityDisplayHelper(treeNode root){
        if(root!=null){
            quantityDisplayHelper(root.left);
            System.out.println(root.goodDisplay()+" ");
            quantityDisplayHelper(root.right);
        }
    }
    void decreasingOrderDisplay(){
        load();
        decreasingOrderDisplayHelper(root);
    }
    void decreasingOrderDisplayHelper(treeNode root){
        if(root!=null){
            decreasingOrderDisplayHelper(root.right);
            System.out.println(root.toString() + " ");
            decreasingOrderDisplayHelper(root.left);

        }
    }
    String  updateHelper(treeNode root){
        if(root!=null){
            return root.toString();//+"\n"+updateHelper(root.left)+"\n"+updateHelper(root.right);
        }

        return "";
    }

    String arrayHelper(treeNode root){//turns the whole tree to one big string separate by "~"
        if(root!=null)
            return root.toString()+"~"+arrayHelper(root.left)+"~"+arrayHelper(root.right);
        return "";
    }


    public void load(){
        // so we can restore the contents of the tree
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile+".txt"));
            String line;
            while ((line = reader.readLine()) != null) {

                String parts[] = line.split("-");
                if (parts.length == 1) continue;
                // System.out.println(line);
                insertItem(parts[1], parts[3], parts[5],Integer.valueOf(parts[7]));
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        // if we add or remove an myDataStructure.item from the list
        // we use this method to update the txt Source file ie to save the list on the computer

        String source  = sourceFile+".txt";
        String data []= arrayHelper(root).split("~");
//        for (int i = 0; i <data.length ; i++) {
//            System.out.println(data[i]);
//        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(source));
            BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
            String line ;
            for (int i = 0; i <data.length ; i++) {
                line = reader.readLine();
                if(data[i].equalsIgnoreCase("")||data[i].equalsIgnoreCase(line))continue;
                writer.write(data[i]+"\n");
            }

            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }





    int countNode(treeNode root){

        if(root==null)return 0 ;
        //we need to traverse left and right of each node




        return 1 + countNode(root.left) + countNode(root.right);
    }

    int size(){
        return countNode(root);
    }





    public treeNode delete(treeNode r,double value){
        treeNode t,t1,t2;
        if(Double.parseDouble(r.itemPrice) == value){
            treeNode L,R;
            L = r.left;
            R = r.right;
            if(L == null && R == null){
                return null;
            }
            else if( L == null){
                t = R;
                return t;
            }
            else if(R == null){
                t = L;
                return t;
            }else{
                t = R;
                t1 = R;
                while(t.left != null){
                    t = t.left;
                }
                t.left = L;
                return t1;
            }
        }
        if(Double.parseDouble(r.itemPrice) < value){
            t2 = delete(r.right,value);
            r.right = t2;
        }else{
            t2 = delete(r.left,value);
            r.left = t2;
        }
        return r;
    }
    public void delete(double value){
        //   load();
        if(isEmpty())
            System.out.println("Empty");
        else{
            root = delete(root,value);
            System.out.println("Node Deleted");
            //   update();
        }
    }



    public boolean ifNodeExits(treeNode root,String n){

        if(root==null)
            return false;
        if(root.itemColors.equalsIgnoreCase(n))
            return true;
        boolean resultLeft =ifNodeExits(root.left,n);
        if(resultLeft)return true ;
        boolean resultRight = ifNodeExits(root.right,n);
        return resultRight;
    }
    public boolean ifNodeExits(String n ){
        if(isEmpty())load();
        return  ifNodeExits(root,n) ;
    }


    treeNode search(treeNode root,String n){
        if(root==null)
            return null;
        if(root.itemName.equalsIgnoreCase(n))
            return root;
        treeNode result = search(root.left,n);
        if(result!=null)
            return result;
        result=search(root.right,n);
        return result;

    }


    treeNode search(String n){

        if(isEmpty())load();
        return search(root,n);
    }


    public treeNode searchColor(treeNode root,String n){
        if(root==null)
            return null;
        if(root.itemColors.equalsIgnoreCase(n))
            return root;
        treeNode result = searchColor(root.left,n);
        if(result!=null)
            return result;
        result=searchColor(root.right,n);
        return result;

    }


    public treeNode searchColor(String n){

        if (isEmpty())load();
        return searchColor(root,n);
    }

    treeNode insertRandomHelper(treeNode root,String n,String p , String c,int q){

        if(root==null){
            root = new treeNode(n,p,c,q);
            return root ;}
        if(Double.parseDouble(p)<Double.parseDouble(root.itemPrice)){
            root.left=insertHelper(root.left,n,p,c,q);
        }
        if(Double.parseDouble(p)>=Double.parseDouble(root.itemPrice)){
            root.right=insertHelper(root.right, n, p, c,q);
        }
//        if(Double.parseDouble(p)==Double.parseDouble(root.itemPrice)){
//
//            double b=Double.parseDouble(p)-0.01;
//            String newP = b+"";
//            root.left = insertHelper(root.left,n,newP,c);
//        }
        return root ;


    }

    public void customerDisplay(){
        if(isEmpty())load();
        customerDisplayHelper(root);
    }
    public void customerDisplayHelper(treeNode root){

        //PreOrder Traversal = Root Left Right
        if(root!=null){
            customerDisplayHelper(root.left);
            if(root.itemQuantity!=0){
                System.out.println(ANSI_PURPLE+"Color :"+root.itemColors+" Price :"+root.itemPrice+"$ Quantity :"+root.itemQuantity);}
            customerDisplayHelper(root.right);

        }
    }


    void loadById(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile+".txt"));
            String line;
            while ((line = reader.readLine()) != null) {

                String parts[] = line.split("-");
                if (parts.length == 1) continue;
                // System.out.println(line);
                insertByID(parts[1], parts[3], parts[5],Integer.valueOf(parts[7]));
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    treeNode insertHelperByID(treeNode root,String n,String p , String c,int q){

        if(root==null){
            root = new treeNode(n,p,c,q);
            return root ;}
        if(Double.parseDouble(p)<Double.parseDouble(root.itemName)){
            root.left=insertHelper(root.left,n,p,c,q);
        }
        if(Double.parseDouble(p)>=Double.parseDouble(root.itemName)){
            root.right=insertHelper(root.right, n, p, c,q);
        }
//        if(Double.parseDouble(p)==Double.parseDouble(root.itemPrice)){
//
//            double b=Double.parseDouble(p)-0.01;
//            String newP = b+"";
//            root.left = insertHelper(root.left,n,newP,c);
//        }
        return root ;


    }

    public void insertByID(String n,String p,String c,int q){
        root=insertHelperByID(root,n,p,c,q);
    }
    public void randomDisplay(){
//        binarySearchTree b = new binarySearchTree(sourceFile);
//        b.loadById();
//        b.customerDisplay();
        if(isEmpty())load();
        randomTraversal(root);

    }

    public void randomTraversal(treeNode root){
        Random rand = new Random();
        int randomInt = rand.nextInt(3);
        if(root!=null){
            if(randomInt==0){
                randomTraversal(root.left);
                if(root.itemQuantity!=0){
                    System.out.println(ANSI_PURPLE+"Color :"+root.itemColors+" Price :"+root.itemPrice+"$ Quantity :"+root.itemQuantity);}
                randomTraversal(root.right);}
            if(randomInt==1) {
                randomTraversal(root.left);
                randomTraversal(root.right);
                if (root.itemQuantity != 0) {
                    System.out.println(ANSI_PURPLE + "Color :" + root.itemColors + " Price :" + root.itemPrice + "$ Quantity :" + root.itemQuantity);
                }
            }
            if(randomInt==2) {
                if (root.itemQuantity != 0) {
                    System.out.println(ANSI_PURPLE + "Color :" + root.itemColors + " Price :" + root.itemPrice + "$ Quantity :" + root.itemQuantity);
                }
                randomTraversal(root.left);
                randomTraversal(root.right);

            }


        }
    }





}