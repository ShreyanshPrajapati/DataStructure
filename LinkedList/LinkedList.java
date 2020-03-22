public class LinkedList {
    static Node head;

    static class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    public void InsertHead(int newData) {
        Node newHead = new Node(newData);
        newHead.next = head;
        head = newHead;
    }

    public void InsertAfter(Node previousNode, int newData) {
        Node newHead = new Node(newData);
        newHead.next = previousNode.next;
        previousNode.next = newHead;
    }

    public void InsertTail(int newData) {
        Node newNode = new Node(newData);
        Node temp = head;
        if (temp == null) {
            head = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void DeleteNode(int key) {
        Node temp = head;
        if (temp != null && temp.data == key) {
            head = temp.next;
            return;
        }
        Node prev = null;
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        if (temp != null) {
            prev.next = temp.next;
        }
    }

    public void DeleteList() {
        head = null;
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(10);
        //Node n2 = new Node(20);
        //Node n3 = new Node(30);
        //head.next = n2;
        //n2.next = n3;
        linkedList.InsertHead(50);
        linkedList.InsertTail(20);
        linkedList.InsertTail(30);
        linkedList.InsertTail(100);
        linkedList.InsertTail(60);
        linkedList.printList(head);
        linkedList.DeleteNode(100);
        linkedList.printList(head);
        linkedList.DeleteNode(10);
        linkedList.printList(head);
        linkedList.DeleteList();
        linkedList.printList(head);
        //System.out.println(head.data + head.next.data);
    }
}
