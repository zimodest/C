package www.jin.java;

public class SLinkListImpl implements ILink {
    private Node head;
    private int size;
    private class Node{
        private Node next;
        private Object data;
        Node(Object data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    @Override
    public boolean add(Object data) {
        Node newNode = new Node(data,null);
        if(this.head == null){
            this.head = newNode;
            this.size++;
            return true;
        }
        Node temp;
        for(temp = this.head;temp.next != null;temp = temp.next)
            ;
        temp.next = newNode;
        this.size++;
        return true;
    }

    @Override
    public int contains(Object data) {
        if(data == null){
            int i = 0;
            for(Node temp = this.head; temp != null;temp = temp.next){
                if( null == temp.data ){
                    return i;
                }
                i++;
            }
        }else {
            int i = 0;
            for(Node temp = this.head; temp != null;temp = temp.next){
                if( data.equals(temp.data ) ){
                    return i;
                }
                i++;
            }
        }
        return 0;
    }

    @Override
    public boolean remove(Object data) {

        if(null == data){

            if(this.head.data == data){
                this.head = head.next;
            }
            Node node = this.head;
            for(Node temp = this.head.next; temp != null;temp = temp.next){

                if(temp.data == data){
                    unLink(node);
                    this.size--;
                    return true;
                }
                node = node.next;
            }
        }else{
            for(Node temp = this.head; temp != null;temp = temp.next){
                if(data.equals(temp.data)){
                    unLink(temp);
                    this.size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        if(!isLinkIndex(index)){
            return null;
        }
        Node temp = node(index);
        temp.data = newData;
        return null;
    }

    @Override
    public Object get(int index) {
        if(!isLinkIndex(index)){
            return null;
        }
        return node(index);
    }

    @Override
    public void clear() {

    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node temp = this.head;
        for(int i = 0; i< this.size;i++){
            temp = temp.next;
            array[i] = temp;
        }
        return new Object[0];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printLink() {
        Node temp;
        for (temp = head; temp != null; temp = temp.next) {
            System.out.println(temp.data);
        }
    }

    private boolean isLinkIndex(int index){
        return index>=0 && index <size;
    }

    private Object unLink(Node x){
        Node temp = x;
        if(x.next == null);
        x.data = x.next.data;
        x.next  = x.next.next;

        return temp;
    }
    private Node node(int index){
        if(!isLinkIndex(index)){
            return null;
        }
        Node temp = this.head;
        int i;
        for(i = 0;i<this.size; i++){
            temp = temp.next;
        }
        return temp;
    }



}
