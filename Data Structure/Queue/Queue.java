class Queue {

    Node head = null;
    Node pushPointer = null;
    final int FIRST_POSITION = 1;

    class Node {
        int data = 0;
        Node next = null;

        Node(int data) {
            this.data = data;
        }
    }

    protected Node createNode(int data) {
        // creating a node
        return new Node(data);
    }

    /**
     * Two pointers we are using one for traversal and another one (pushPointer) for
     * adding node at last.
     * By using above technique, our time complexity will constant O(1)
     * 
     * @param data - data to be added in the stack
     * 
     */
    public void enQueue(int data) {
        try {
            Node node1 = this.createNode(data);
            if (this.head == null) {
                // it refers first element
                this.head = node1;
                this.pushPointer = node1;
            }

            this.pushPointer.next = node1;
            this.pushPointer = node1;

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void show() {
        try {
            this.print("", true);
            Node temp = this.head;
            while (temp != null) {
                this.print(temp.data + " -> ", false);
                temp = temp.next;
            }
            this.print("end", false);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void print(Object message, Boolean newLine) {
        if (newLine) {
            System.out.println(message.toString());
        } else {

            System.out.print(message.toString());
        }
    }

    public int size() {
        Node temp = this.head;

        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    /**
     * Pop function finds second last element to delete last node. So it's time
     * complexity will always be O(N-1)
     * 
     * @return Boolean
     * @author Deepak Atariya
     */
    public void deQueue() {
        this.print("", true);
        try {
            this.print("Dequeued : " + this.head.data, false);
            this.head = this.head.next;
        } catch (Exception e) {
            this.print("Unable to delete", true);
        }
    }

    public Node find(int position) {
        Node temp = this.head;
        int count = 1;
        while (temp.next != null) {
            if (count == position) {
                break;
            }
            temp = temp.next;
            count++;
        }
        return temp;
    }

    public static void main(String[] args) throws Exception {
        Queue llist = new Queue();

        llist.enQueue(10);
        llist.enQueue(20);
        llist.enQueue(30);
        llist.enQueue(40);
        llist.enQueue(50);
        llist.enQueue(60);
        llist.enQueue(70);
        llist.enQueue(80);
        llist.enQueue(90);
        llist.enQueue(100);
        llist.show();
        llist.deQueue();
        llist.show();
        llist.deQueue();
        llist.show();
        // llist.deQueue();
        // llist.show();
        // llist.deQueue();
        // llist.show();
        // llist.deQueue();
        // llist.show();
        // llist.deQueue();
        // llist.show();
        // llist.deQueue();
        // llist.show();
        // llist.deQueue();
        // llist.show();

    }
}
