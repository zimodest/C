class ListLink{
    Node head;
    int size;
    class Node{
        Node next;
        int data;
        Node(){
            this.data = 0;
            this.next = null;
        }
        Node(int data, Node node){
            this.data = data;
            this.next = node;
        }
    }

    public void add(int data){
        Node newNode = new Node(data,null);
        if(this.head == null){
            this.head = newNode;
        }else{
        Node temp;
        for(temp = this.head;temp.next != null;temp = temp.next){

        }
        temp.next = newNode;
        }
    }

    public Node getNext(Node node){
        return node.next;
    }

    public Node gethead(){
        return this.head;
    }

    public void set(Node node, int data){
        node.data = data;
    }

    public void print(){
        for(Node temp = this.head;temp != null; temp = temp.next){
            if(temp.next == null){
                System.out.print(temp.data+"\n");

                break;
            }
            System.out.print(temp.data+"---->");
        }

    }

}


public class ListNodeTest{
    public static void main(String[] args){
        ListLink link1 = new ListLink();
        ListLink link2 = new ListLink();
        ListLink link3 = new ListLink();
        link1.add(2);
        link1.add(4);
        link1.add(3);
        link2.add(5);
        link2.add(6);
        link2.add(4);
        link3.add(0);
        

        ListLink.Node temp1 = link1.gethead();
        ListLink.Node temp2 = link2.gethead();
        ListLink.Node temp3 = link3.gethead();
        int data;
        while(temp1 != null){
        data = temp1.data + temp2.data+temp3.data;
        if(data >= 10){
            link3.set(temp3,data % 10);
            link3.add(data / 10);
        }else{
            link3.set(temp3,data);
            if(temp1.next != null){
            link3.add(0);}
        }
            temp1 = temp1.next;
            temp2 = temp2.next;
            temp3 = temp3.next;
        }

        link1.print();
        link2.print();
        link3.print();

    }
}