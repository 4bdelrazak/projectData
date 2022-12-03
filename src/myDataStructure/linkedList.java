package myDataStructure;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class linkedList {

    public static class encryptor{
        public String encryptString(String passWord) throws NoSuchAlgorithmException {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest  = md.digest(passWord.getBytes());

            BigInteger bigInt = new BigInteger(1,messageDigest);


            return  bigInt.toString(16);
        }


    }
    public static void print(String s){
        final String ANSI_PURPLE = "\u001B[35m";
        System.out.println(ANSI_PURPLE+s);
    }
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_RESET = "\u001B[0m";


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



    public node first ;
    Scanner input ;
    public String sourceFile ;
    public linkedList(String sourceFile){
        input = new Scanner(System.in);
        this.sourceFile=sourceFile;
        load();

    }
    boolean isEmpty(){
        return first==null;
    }
    public  void insertAtFront(String userName,String passWord,boolean plus){
        node newNode = new node(userName,passWord,plus);
        if(isEmpty()){
            first=newNode ;
            return;
        }
        newNode.next=first;
        first=newNode;
    }
    public void insertAtFront(String userName,String passWord){
        node newNode = new node(userName,passWord);
        if(isEmpty()){
            first=newNode ;
            return;
        }
        newNode.next=first;
        first=newNode;
    }

    public void insert(String userName,String passWord){
        if(isEmpty())
            load();
        node newNode = new node(userName,passWord);
        node duplicate = checkIfDuplicate(newNode);
        if(duplicate!=null){
            Scanner scan = new Scanner(System.in);

            print("UserName taken please enter a new UserName :");
            userName= scan.nextLine();
            insert(userName,passWord);

            return;
        }


        insertAtFront(userName,passWord);
        update();
    }

    public String passWordByUser(){
        return input.nextLine();
    }
    public String userNameByUser(){
        return input.nextLine();
    }
    public boolean validUsername(String userName){
        node checking = checkIfDuplicate(new node(userName));
        return checking==null;
    }
    public void insertByUser() throws NoSuchAlgorithmException {
        // this is for when the user want to register
        // we can have 2 of the same username when a new customer want to register
        String userName ;
        String passWord ;
        print("Please enter your userName :");
        userName= input.nextLine();
        while(!validUsername(userName)){
            System.out.print(ANSI_RED+"USERNAME TAKEN \nPlease try again :"+ANSI_RESET);
            userName=passWordByUser();
        }
        print("Please enter your password");
        String passWordPre = input.nextLine();
        // isValidPassword(passWord);
        while(!isValidPassword(passWordPre)){
            System.out.print(ANSI_RED+"INVALID PASSWORD \nPlease try again :"+ANSI_RESET);
            passWordPre=passWordByUser();
        }
        encryptor e = new encryptor();
        passWord = e.encryptString(passWordPre);
        insert(userName,passWord);
    }

//    void insert(String itemName,String itemPrice,String itemColors){
//
//        node newNode = new node(itemName, itemPrice, itemColors);
//        node dupilcate = checkIfDuplicate(newNode);
//        if(dupilcate!=null){
//            System.out.println("The myDataStructure.item you entered is already in the store \n Do you want to edit it ?    0/1");
//            int answer = input.nextInt();
//            if(answer==1){
//                String userInput[] = new String[3];
//                String itemAttr[] = {"name","price","colors"};
//                for (int i = 0; i <3 ; i++) {
//                    System.out.println("Item "+itemAttr[i]+ ":");userInput[i]=input.next();
//                }
//
//                dupilcate.edit(userInput[0],userInput[1],userInput[2] );
//
//            }
//            return;
//        }
//
//        insertAtFront(itemName,itemPrice,itemColors);
//
//
//        update();
//
//
//
//    }






    public void load(){
        //    0-      1-         2-         3  -    4        5
        // username-theUsername-passWord-thePAssword-status-thestatus
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile+".txt"));
            String line;
            while ((line = reader.readLine()) != null) {

                String parts[] = line.split("-");
                if (parts.length == 1) continue;
                // System.out.println(line);
                boolean s ;
                if(parts[5].equalsIgnoreCase("true"))
                    s=true;
                else s=false;
                insertAtFront(parts[1], parts[3], s);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void  display(){
        if(isEmpty()) {
            load();
        }


        node current = first ;
        while(current!=null){
            System.out.println(current.nodeDisplay()+" ");
            current=current.next;
        }
    }
    public node checkIfDuplicate(node newNode){
        //to check if the myDataStructure.item has been added before
        //node newNode = new node(itemName, itemPrice, itemColors);
        if(isEmpty())
            load();
        node current = first;
        while(current!=null){
            if(current.data.userName.equalsIgnoreCase(newNode.data.userName))
                return current ;
            current=current.next;
        }
        return null;

    }
    public   node search(node check){
        return checkIfDuplicate(check);
    }
    public void delete(String itemName){
        node current = first;
        node prev = current;
        while(current!=null){
            if(current.data.userName.equalsIgnoreCase(itemName))break ;
            prev = current;
            current=current.next;
        }
        if (current==first){
            first=first.next ;
            //count--;
            update();
            return ;
        }
        node temp =current.next ;
        prev.next=temp;
        //  count--;
        update();
        return ;

    }

    public void update(){
        // if we add or remove an myDataStructure.item from the list
        // we use this method to update the txt Source file ie to save the list on the computer
        node current=first;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(sourceFile+".txt"));
            while(current!=null){
                writer.write(current.nodeDisplay()+"\n");
                current=current.next;
            }
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
//    public item getItemByName(String name){
//        //so that the user inserts the item into the cart by just writing the item's name
//        //the inserted item is located in the linked list of items
//        //example: s.push(ll.getItemByName("pants"));
//        node curr = first;
//        item Item = new item();
//        while (curr != null) {
//            if(curr.itemName.equalsIgnoreCase(name)){
//                Item.itemName = curr.itemName;
//                Item.itemPrice = curr.itemPrice;
//                Item.itemColors = curr.itemColors;
//                return Item;
//            }
//            curr = curr.next;
//        }
//        return Item;
//    }
//
//    public void getItemsWithSpecificColor(String color){
//        node curr=first;
//        item currItem = new item();
//        item[] Items=new item[count];
//        int size=count;
//        for (int i=0;i<size;i++) {
//            if (curr.itemColors.contains(color.substring(0,1).toUpperCase()+color.substring(1))) {
//                currItem.itemName = curr.itemName;
//                currItem.itemPrice = curr.itemPrice;
//                currItem.itemColors = curr.itemColors;
//                Items[i]=currItem;
//                curr=curr.next;
//                currItem=null;
//            }
//            else {
//                System.out.println("Make sure that you write the color correctly");
//            }
//        }
//        for(int i=0;i<Items.length;i++){
//            System.out.println(Items[i]);
//        }
//    }
//





}
