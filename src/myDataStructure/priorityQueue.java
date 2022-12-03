package myDataStructure;
public class priorityQueue {

    public class node {
        node next ;
        order data ;

        int priority ;

        public node(){}
        public node(order data){
            this.data=data;
            next = null;
        }
        public node(order data,int priority){
            this.data=data;
            this.priority=priority;
        }

        @Override
        public String toString(){
            return     data.toString()       ;
        }
    }


    public class linkedListQ{


        String name;
        public node first ;
        linkedListQ(){
            first=null;
            this.name = name ;
        }
        boolean isEmpty(){
            return first==null;
        }
        void insert(order data){
            //insertion at back
            node newNode = new node(data);
            if(isEmpty()){
                first = newNode;
                return ;
            }
            node current = first;
            while(current.next!=null){
                current=current.next ;

            }
            current.next = newNode ;
        }
        void insert(order data,int priority){
            //insert at front
            node newNode= new node(data,priority);
            if(isEmpty()){
                first= newNode;
                return;
            }
            newNode.next = first;
            first=newNode ;
        }
        node deleteFromFront(){
            if(isEmpty()){

                System.out.println("The list is empty!");
                return null;
            }
            node temp = first ;
            first=first.next;
            return temp ;
        }
        void insertPar(order data,int par){   //50   12     7
            if(isEmpty()){
                first = new node(data , par);
                return ;

            }
            if(par==0){
                insert(data);
                return;
            }
            node current = first  ;
            node prev = current ;
            node newNode = new node(data,par);
            while(current.next!=null){
                if(par>current.priority){
                    break ;
                }
                prev =current;
                current=current.next ;
            }
            if(first==current){
                newNode.next = first ;
                first= newNode ;
                return ;

            }
            node temp = prev.next ;
            prev.next =newNode ;
            newNode.next = temp;

            return ;



        }



        void insertWithP(order data , int par){
            if(isEmpty()){
                first = new node(data,par);

                return;
            }
            if(par==0){
                insert(data);
                return ;
            }
//    if(par< first.priority){
//        node newNode = new node(data,par);
//       node temp = first.next;
//        first.next= newNode;
//        newNode.next=temp ;
//        return;
//    }
            node current = first;
            node prev = current ;//   4   3
            while(current.next!=null) {
                if (par> current.priority) {

                    break;
                }
                prev =current;
                current=current.next ;
            }
            node newNode =new node(data,par);         /// 6 3 2 1
            if(current==first){
                if(par>current.priority){
                    newNode.next=first ;
                    first=newNode;
                    return ;
                }
                if(par<current.priority){

                    node temp = first.next;
                    first.next = newNode ;
                    newNode.next = temp;
                    return;}

            }

            node temp = prev.next ;
            prev.next  = newNode ;
            newNode.next= temp;



        }
        void display(){
            node current = first ;
            while(current.next!=null){
                System.out.print(current.data+"-->");
                current=current.next ;
            }
            System.out.println(current.data);
            System.out.println();




        }


    }



    public linkedListQ list  ;
    int count  ;

    int lastPriority ;
    public priorityQueue(){
        count=0;
        lastPriority = 1 ;
        list = new linkedListQ();
    }

    //    priorityQueue(String name ){
//        count=0;
//        list = new linkedList(name);
//    }
    boolean isEmpty(){
        return list.isEmpty();
    }
    void enQueue(order data,int priority){
        list.insertWithP(data,priority);
        count++;
//        list.insertPar(data,priority);
    }

    public void enQueueWithP(order data){
        list.insertWithP(data,lastPriority++);
        count++;
    }


    public void enQueue(order data){
        if(data.customer.plus==true){
            enQueueWithP(data);
            return;
        }
        list.insert(data);
        count++;
    }
    node deQueue(){
        count--;
        return this.list.deleteFromFront();
    }



    public void display(){
        // priorityQueue copQueue = new priorityQueue(this);
        priorityQueue copyQ = new priorityQueue();
        copyQ.list.first = this.list.first;
        //  System.out.println(copyQ.list.first);
        copyQ.count=count;
        int counter = 1;
        while(!copyQ.isEmpty()){
            if(copyQ.count==1)break;
            System.out.print("#"+counter+" "+copyQ.deQueue().data +"\n");
            counter++;
        }
        System.out.println("#"+counter+" "+copyQ.deQueue().data+"\n");



    }

    void removeElement(order a ){
        priorityQueue newQ = new priorityQueue();
        boolean found = false ;
        while(!isEmpty()){
            node temp = deQueue();
            if(temp.data!=a){

                newQ.enQueue(temp.data, temp.priority);
            }
            else{
                found =true ;
            }

        }
        count = newQ.count;
        this.list=newQ.list;
        this.list.first=newQ.list.first;

        if(found==false){
            System.out.println("The number is not found !");
        }
    }



    public boolean displayOrder(String name){
        // priorityQueue copQueue = new priorityQueue(this);
        priorityQueue copyQ = new priorityQueue();
        copyQ.list.first = this.list.first;
        //  System.out.println(copyQ.list.first);
        copyQ.count=count;
        int counter = 1;
        while(!copyQ.isEmpty()){
            if(copyQ.count==1)break;
            priorityQueue.node temp = copyQ.deQueue();
            if(temp.data.customer.userName.equalsIgnoreCase(name)){
                System.out.print("#"+counter+" "+temp.data +"\n");
                return true;}
            counter++;
        }
        priorityQueue.node temp = copyQ.deQueue();
        if(temp.data.customer.userName.equalsIgnoreCase(name)){
            System.out.println("#"+counter+" "+temp.data+"\n");
            return true;}

        return false;

    }



}
