package www.jin.java;

//接口声明
interface ILink{
        /**
         * 链表增加节点操作
         * @param data 节点内容
         * @return
         */
        boolean add(Object data);

        /**
         * 判断指定内容节点在链表中是否存在
         * @param data 要判断的内容
         * @return 返回找到的节点索引
         */
        int contains(Object data);

        /**
         * 删除指定内容节点
         * @param data
         * @return
         */
        boolean remove(Object data);

        /**
         * 根据指定下标修改节点内容
         * @param index 索引下标
         * @param newData 替换后的内容
         * @return 替换之前的节点内容
         */
        Object set(int index,Object newData);

        /**
         * 根据指定下标返回节点内容
         * @param index
         * @return
         */
        Object get(int index);

        /**
         * 链表清空
         */
        void clear();

        /**
         * 将链表转为数组
         * @return 返回所有节点内容
         */
        Object[] toArray();

        /**
         * 链表长度
         * @return
         */
        int size();

        /**
         * 遍历链表
         */
        void printLink();
}

class LinkListImpl implements ILink {
    private Node head;
    private Node last;
    private int size;

    private class Node {
        private Node prev;
        private Object data;
        private Node next;

        Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 添加结点内容
     * @param data 节点内容
     * @return
     */
    @Override
    public boolean add(Object data) {
        Node temp = this.last;
        Node newNode = new Node(temp, data, null);
        this.last = newNode;
        if (this.head == null) {
            this.head = newNode;
        } else {
            temp.next = newNode;
        }
        this.size++;
        return true;
    }

    @Override
    public int contains(Object data) {
        if(data == null){
            int i = 0;
            for(Node temp = this.head;temp != null;temp = temp.next){
                if(temp.data == null){
                    return i;
                }
                i++;
            }
        }
        else{
            int i = 0;
            for(Node temp = this.head;temp != null;temp = temp.next){
                if(temp.data.equals(data)){
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Override
    public boolean remove(Object data) {
        if(data == null) {
            for (Node temp = this.head; temp != null; temp = temp.next) {
                if (temp.data == null) {
                    unLink(temp);
                    return true;
                }
            }
        }else{
            for (Node temp = this.head; temp != null; temp = temp.next) {
                if (temp.data.equals(data)) {
                    unLink(temp);
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
        Node node = node(index);
        Object element = node.data;
        node.data = newData;
        return element;
    }

    @Override
    public Object get(int index) {
        if(!isLinkIndex(index)){
            return null;
        }
        return node(index).data;
    }

    @Override
    public void clear() {
        Node temp;
        for(temp = this.head; temp != null;){
            temp.data = null;
            Node node = temp.next;
            temp.prev = null;
            temp.next = null;
            temp = null;
            temp = node;
        }
        head = null;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node temp = head;
        for (int i = 0; i < size; i++) {
            arr[i] = temp.data;
            temp = temp.next;
        }
        return arr;
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

    /**
     * 根据索引取得具体结点
     * @param index
     * @return
     */
    private Node node(int index) {
        if (index <= (size >> 1)) {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
        if (index > (size >> 1)) {
            Node temp = last;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
            return temp;
        }
        return null;
    }

    private boolean isLinkIndex(int index){
        return index>=0 && index <size;
    }

    private Object unLink(Node x){
        Object elementData = x.data;
        Node prev = x.prev;
        Node next = x.next;
        if(prev == null){
            this.head = next;
        }else{
            prev.next = next;
            x.prev = null;
        }
        if(next == null){
            this.last = prev;
        }else{
           prev.next = next;
           x.next = null;
        }
        x.data = null;
        this.size--;
        return elementData;
    }

}



public class Test {
    public static void main(String[] args) {
        LinkListImpl link = new LinkListImpl();
        link.add("火车头");
        link.add("第一节车厢");
        link.clear();
        link.printLink();

    }
}

