package myDataStructure;

public class node {
    //         String itemName ;
//         String itemPrice ;
//         String itemColors ;
    public node next ;
    public customer data ;
    public node(){
        data = null ;
        next = null ;
    }
    public node(String userName){
        data = new customer(userName,null);
        next=null;
    }
    public node(String userName,String passWord){
        data= new customer(userName,passWord);
        next= null;
    }
    public node(String userName,String passWord,boolean plus){
        data= new customer(userName,passWord,plus);
        next= null;
    }
    public String nodeDisplay(){
        return "userName-"+data.userName+"-password-"+data.passWord+"-plus-"+data.plus;
    }
//        node next ;
//        node(String itemName,String itemPrice,String itemColors){
//            this.itemName=itemName;
//            this.itemPrice=itemPrice;
//            this.itemColors=itemColors;
//        }
//
//        String nodeDisplay(){
//            return "itemName-"+itemName+"-itemPrice-"+itemPrice+"-itemColors-" +itemColors;
//        }
//
//
//        public void edit(String itemName,String itemPrice,String itemColors) {
//            this.itemName=itemName;
//            this.itemPrice=itemPrice;
//            this.itemColors=itemColors;
//            update();
//        }
}//myDataStructure.item in the store
