class LinkedList {

    Node head = null;
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
     * addLast insert an element at first position by default
     * Completed
     * 
     * @param data
     */
    public void add(int position, int data) {
        try {
            int listSize = this.size();
            position = listSize < position ? listSize : position;
            Node node = this.createNode(data);

            if (position > 0) {
                Node temp = this.find(position);
                node.next = temp.next;
                temp.next = node;
            } else {
                node.next = this.head;
                this.head = node;
            }

        } catch (Exception e) {
            System.out.println("Invalid input");
        }
    }

    /**
     * addLast insert an element at first position by default
     * 
     * @param data
     */
    public void addLast(int data) {
        try {
            int listSize = this.size();
            this.add(listSize, data);

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
            this.add(this.FIRST_POSITION - 1, data);
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
            System.out.println("null");

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

    public boolean deleteFirst() {
        try {
            return this.delete(this.FIRST_POSITION);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleteLast() {

        try {
            int listSize = this.size();
            return this.delete(listSize);
        } catch (Exception e) {
            this.print("Unable to delete");
            return false;
        }
    }

    public boolean delete(int position) {

        try {
            int listSize = this.size();
            if (listSize > 0) {
                position = position - 1;
                if (position > 0 && position <= listSize) {
                    Node temp = this.find(position);
                    if (position == listSize - 1) {
                        temp.next = null;
                    } else {
                        temp.next = temp.next.next;
                    }
                } else if (position == 0) {
                    this.head = this.head.next;
                } else {
                    this.print("Invalid Position : " + position);
                }
            } else {
                throw new Exception("List is empty");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public Node find(int position) {
        // taking first node reference for traversing
        Node temp = this.head;
        int count = 1;
        // traversing to the last element
        while (temp.next != null) {
            if (count == position) {
                break;
            }
            temp = temp.next;
            count++;
        }
        return temp;
    }

    public boolean update(int position, int data) {

        try {
            int listSize = this.size();
            if (listSize > 0) {
                if (position <= listSize) {
                    Node temp = this.find(position);
                    temp.data = data;
                } else {
                    this.print("Invalid Position : " + position);
                }
            } else {
                throw new Exception("List is empty");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    public boolean updateLast(int data) {
        try {
            int last = this.size();
            return this.update(last, data);
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateFirst(int data) {
        try {
            return this.update(this.FIRST_POSITION, data);
        } catch (Exception e) {
            this.print("Error occured");
        }
        return false;
    }

    public void sort() {
        Node fp = this.head;
        while (fp.next != null) {
            Node sp = fp.next;
            while (sp != null) {
                if (fp.data > sp.data) {
                    this.swap(fp, sp);
                }
                sp = sp.next;
            }
            fp = fp.next;
        }
    }

    public void swap(Node fp, Node sp) {
        int data = fp.data;
        fp.data = sp.data;
        sp.data = data;
    }

    public static void main(String[] args) throws Exception {
        LinkedList llist = new LinkedList();

        
        llist.add(1, 10);
        llist.add(3, 20);
        llist.add(2, 40);
        llist.add(-50, 05);
        llist.add(0, 5000);
        
        llist.show();
        llist.deleteFirst();
        
        llist.show();
        llist.updateLast(101);
        llist.show();
        
    }
}