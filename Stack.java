class Stack {

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
    public void push(int data) {
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

            Node temp = this.head;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void print(String message) {
        System.out.println(message);
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
    public boolean pop() {
        try {
            int listSize = this.size();
            if (listSize <= 0) {
                this.print("Stack is empty!");
                return false;
            }
            Node temp = this.find(listSize - 1);
            temp.next = null;
            return true;
        } catch (Exception e) {
            this.print("Unable to delete");
            return false;
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
        Stack llist = new Stack();

        llist.push(10);
        llist.push(20);
        llist.push(30);
        llist.show();
        llist.pop();
        llist.show();

    }
}