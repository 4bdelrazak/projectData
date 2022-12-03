package myDataStructure;

import java.util.ArrayList;

public class order {

    public customer customer ;
    public ArrayList<item> items ;

    public String address ;

    public order (){
        customer=null;
        items =null ;
    }
    public order (customer c ,ArrayList<item> items,String address){
        customer=c  ;
        this.items = items;
        this.address=address;
    }


    public String arrayListDisplayOne(){
        return items.toString().replaceAll("[\\[\\](){}]","").trim();

    }
    public String arrayListDisplayTwo(){
        return arrayListDisplayOne().replaceAll(",","\n").trim();
    }
    public String arrayListDisplay(){
        return arrayListDisplayTwo().replaceAll(" ","");
    }


    @Override
    public String toString(){
        return "\nName : "+customer.userName+"\nAddress : "+address+"\nItems :\n"+arrayListDisplay();
    }



}

