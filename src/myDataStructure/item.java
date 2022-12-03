package myDataStructure;

public class item {

    public String itemName ;// rgb code
    public String itemPrice ;//price
    public String itemColors ;//the name / color
    public int itemQuantity ;
    protected item(){

    }
    public item(String name, String price, String colors,int q){
        itemName=name ;
        itemPrice=price;
        itemColors=colors;
        itemQuantity=q;
    }
    public item(String name, String price, String colors){
        itemName=name ;
        itemPrice=price;
        itemColors=colors;

    }

    @Override
    public String toString(){
        return "itemName-"+itemName+"-itemPrice-"+itemPrice+"-itemColors-"+itemColors+"-itemQuantity-"+itemQuantity;

    }

    // 0           1           2           3            4              5          6
    // itemName   name      itemPrice     price      itemColor        color    itemQuantity




}
