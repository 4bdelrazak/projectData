package myDataStructure;



public class customer {


    // by defualt all customer wont have the plus subscription
    public String userName ;
    public String passWord ;
    public boolean plus ;
    // shopping list we be another object we need to implement
    public customer(){

    }

    //setting the plus feature by default
    public customer(String userName,String passWord){
        this.userName=userName;
        this.passWord=passWord;
        plus= false;

    }
    public customer(String userName,String passWord,boolean plus){
        this.userName=userName;
        this.passWord=passWord;
        this.plus= plus;

    }

    public void subscribe(){
        this.plus=true;
    }






}