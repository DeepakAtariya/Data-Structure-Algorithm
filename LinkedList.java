class LinkedList {

    Node head = null;

    class Node {
        int data = 0;
        Node next = null;

        // public int toString(Node node) {
        // return node.data;
        // }
    }

    /**
     * addLast insert an element at first position by default
     * 
     * @param data
     */
    public void add(int position, int data) {
        try {
            position = position - 1;
            int listSize = this.size();

            // creating a node
            Node node = new Node();
            node.data = data;
            node.next = null;

            // checking whether list is empty or not
            if (this.head == null) {
                if (position > 1) {
                    System.out.println("List is empty and position is invalid. we are putting in first position");
                }
                // Going to push first element
                this.head = node;

            } else {

                if (position <= 0) {
                    if (position < 0) {
                        this.print("Invalid postion given. Adding at first");
                    }
                    node = null;
                    this.addFirst(data);
                } else {
                    if (position >= listSize) {
                        if (position > listSize) {
                            this.print("Invalid position given. Adding at last");
                        }
                        node = null;
                        this.addLast(data);
                    } else {

                        // taking first node reference for traversing
                        Node temp = this.head;

                        int count = 1;

                        // traversing to the last element
                        while (temp != null) {
                            if (count == position) {
                                break;
                            }

                            // this.print(temp.data + " at " + count);
                            temp = temp.next;
                            count++;

                        }

                        // this.print(temp.data + " is found at " + count);
                        // storing node in last position
                        node.next = temp.next;
                        temp.next = node;
                    }
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * addLast insert an element at first position by default
     * 
     * @param data
     */
    public void addLast(int data) {
        try {

            // creating a node
            Node node = new Node();
            node.data = data;
            node.next = null;

            // checking whether list is empty or not
            if (this.head == null) {
                // Going to push first element
                this.head = node;

            } else {
                // taking first node reference for traversing
                Node temp = this.head;

                // traversing to the last element
                while (temp.next != null) {

                    temp = temp.next;
                }

                // storing node in last position
                temp.next = node;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * addLast insert an element at last position by default
     * 
     * @param data
     */
    public void addFirst(int data) {
        try {
            // creating a node
            Node node = new Node();
            node.data = data;
            // assigin old reference to new node
            node.next = this.head;

            // assiging the new node to head (first node)
            this.head = node;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void show() {
        try {

            Node temp = this.head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.print("null");

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
        // this.print("List size : " + count);
        return count;
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        llist.addLast(100);
        llist.addLast(200);
        llist.addFirst(50);
        llist.add(1, 40);
        llist.show();
    }
}