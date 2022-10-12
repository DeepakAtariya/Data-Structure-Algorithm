class CircularLinkedList {

    Node head = null;

    static class Node {
        int data = 0;
        Node next = null;

        // public int toString(Node node) {
        // return node.data;
        // }
    }

    /**
     * addLast insert an element at first position by default
     * Completed
     * 
     * @param data
     */
    public void add(int position, int data) {
        try {
            position = position - 1;
            int listSize = this.size();
            // this.print("list size : " + String.valueOf(listSize));

            // creating a node
            Node node = new Node();
            node.data = data;
            node.next = null;

            // checking whether list is empty or not
            if (this.head == null) {
                if (position < 1) {
                    // System.out.println("List is empty and position is invalid. we are putting in
                    // first position");
                }
                // Going to push first element
                this.head = node;
                this.head.next = this.head;

            } else {
                if (position <= 0) {
                    if (position < 0) {
                        // this.print("Invalid postion given. Adding at first");
                    }
                    node = null;
                    this.addFirst(data);
                } else {
                    if (position >= listSize) {
                        if (position > listSize) {
                            // this.print("Invalid position given. Adding at last");
                        }
                        node = null;
                        this.addLast(data);
                    } else {
                        // searching node for particular position.
                        Node temp = this.find(position);

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
                node.next = head;

            } else {
                // taking first node reference for traversing
                Node temp = this.head.next;

                // traversing to the last element
                do {
                    temp = temp.next;
                } while (temp != this.head.next);

                // storing node in last position
                // temp.next = node;
                node.next = temp;
                this.head.next = node;
                this.head = node;
                // 1-2-3-4
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

            if (this.head == null) {
                this.head = node;
                node.next = this.head;
            } else {
                // this.head.next = node;
                node.next = this.head.next;
                this.head.next = node;
                // this.head = node;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 
     */
    public void show() {
        try {
            Node temp = this.head.next;
            do {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            } while (temp != this.head.next);
            System.out.println("repeat");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 
     * @param message
     * 
     */
    public void print(Object message) {
        System.out.println(message.toString());
    }

    /**
     * 
     * @return
     * 
     */
    public int size() {
        int count = 0;

        if (this.head != null) {
            // first node of the list
            Node temp = this.head.next;
            do {
                count++;
                temp = temp.next;
            } while (temp != this.head.next);

        }

        return count;
    }

    public boolean deleteFirst() {

        try {
            if (this.head == null) {
                this.print("Nothing to delete");
            } else {
                this.print("Deleted : " + this.head.next.data);
                this.head.next = this.head.next.next;
            }
        } catch (Exception e) {
            // this.print("Error occured");
            throw e;
        }
        return true;
    }

    public boolean deleteLast() {

        try {
            if (this.head == null) {
                this.print("Nothing to delete");
            } else {
                Node temp = this.head.next;
                do {
                    temp = temp.next;
                } while (temp.next != this.head);
                this.print("Deleted : " + temp.next.data);
                temp.next = this.head.next;
                this.head = temp;
            }
        } catch (Exception e) {
            throw e;
        }
        return true;
    }

    public boolean delete(int position) {

        try {
            int listSize = this.size();

            // checking whether list is empty or not
            if (this.head == null) {
                if (position > 1) {
                    System.out.println("List is empty and nothing can be deleted...");
                }
            } else {

                if (position <= 0) {
                    if (position < 0) {
                        this.print("Given position is smaller than list size");
                    }
                } else {

                    if (position == 1) {
                        // delete first element
                        this.deleteFirst();
                    } else if (position == listSize) {
                        // delete last element
                        this.deleteLast();
                    } else {
                        if (position > listSize) {
                            this.print("Given position is greater than list size");
                        } else {
                            // we will find an previous element of given position and de-reference target node
                            Node temp = this.find(position - 1);
                            temp.next = temp.next.next;
                        }
                    }

                }

            }

            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public Node find(int position) {
        Node temp = null;
        int count = 1;
        if (this.head != null) {
            // taking first node reference for traversing
            temp = this.head.next;

            do {
                if (count == position) {
                    break;
                }
                count++;
                temp = temp.next;
                // traversing to the last element
            } while (temp != this.head.next);

        }
        return temp;
    }

    public boolean update(int position, int data) {
        try {
            int listSize = this.size();

            // checking whether list is empty or not
            if (this.head == null) {
                if (position > 1) {
                    System.out.println("List is empty and nothing can be deleted...");
                }
            } else {

                if (position <= 0) {
                    if (position < 0) {
                        this.print("Given position is smaller than list size");
                    }
                } else {

                    if (position == 1) {
                        // delete first element

                        this.updateFirst(data);
                    } else if (position == listSize) {
                        // delete last element
                        this.updateLast(data);
                    } else {
                        if (position > listSize) {
                            this.print("Given position is greater than list size");
                        } else {

                            // searching node for particular position.
                            Node temp = this.find(position + 1);

                            this.print("Going to update : " + temp.data);
                            temp.data = data;
                            // temp.next = null;
                        }
                    }

                }
            }

            return true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateLast(int data) {

        try {
            if (this.head == null) {
                this.print("Nothing to delete");
            } else {
                Node temp = this.head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                this.print("Going to update : " + temp.data);
                temp.data = data;
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean updateFirst(int data) {

        try {
            if (this.head == null) {
                this.print("Nothing to delete");
            } else {
                this.print("Going to delete : " + this.head.data);
                this.head.data = data;
            }
            return true;
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

    public static void main(String[] args) {
        CircularLinkedList llist = new CircularLinkedList();

        // additions
        llist.add(1, 40);
        llist.add(1, 50);
        // llist.print("head is pointing to : "+String.valueOf(llist.head.data));
        llist.add(2, 60);
        llist.add(1, 45);
        llist.add(5, 80);
        llist.print("size " + llist.size());
        llist.show();

        // deletions
        llist.deleteFirst();
        llist.show();
        llist.deleteLast();
        llist.show();
        llist.delete(-100);
        llist.show();

        // llist.addLast(100);
        // llist.addLast(200);
        // llist.addLast(300);
        // llist.addLast(400);
        // llist.addLast(500);
        // llist.addFirst(500);
        // llist.add(3, 70);
        // llist.addFirst(40);
        // llist.addFirst(50);
        // llist.addFirst(60);
        // llist.addFirst(70);
        // llist.print(String.valueOf(llist.size()));
        // llist.update(70, 39);
        // llist.update(3, 39);
        // llist.update(4, 201);
        // llist.update(2, 101);
        // llist.show();
        // llist.sort();
        // llist.show();
        // llist.show();
    }
}