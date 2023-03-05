class DoublyLinkedList {

    Node head = null;
    Node end = null;

    class Node {
        int data = 0;
        Node next = null;
        Node pre = null;
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

                        // searching node for particular position.
                        Node found = this.find(position);
                        // this.print("Found element " + found.data);

                        // this.print(temp.data + " is found at " + count);
                        // storing node in last position
                        node.next = found.next;
                        node.pre = found;
                        found.next.pre = node;
                        found.next = node;
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

            // checking whether list is empty or not
            if (this.head == null) {
                // Going to push first element
                this.head = node;
                this.end = node;

            } else {
                // taking first node reference for traversing
                Node temp = this.end;
                // storing node in last position
                node.pre = temp;
                temp.next = node;
                this.end = node;
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
            if (this.head == null) {
                this.end = node;
            } else {
                this.head.pre = node;
            }
            this.head = node;
            // this.end = node;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 
     */
    public void show(Boolean direction) {
        try {

            if (direction) {
                this.print("|->->->->Forward->direction->->->->");
                Node temp = this.head;
                while (temp != null) {
                    System.out.print(temp.data + " -> ");
                    temp = temp.next;
                }
                System.out.println("null");
            } else {
                this.print("<-<-<-<-Backward<-direction<-<-<-<-|");
                Node temp = this.end;
                while (temp != null) {
                    System.out.print(temp.data + " -> ");
                    temp = temp.pre;
                }
                System.out.println("null");

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 
     * @param message
     * 
     */
    public void print(String message) {
        System.out.println(message);
    }

    /**
     * 
     * @return
     * 
     */
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

    public boolean deleteFirst() {

        try {
            if (this.head == null) {
                this.print("Nothing to delete");
            } else {
                this.print("Going to delete : " + this.head.data);
                this.head = this.head.next;
                this.head.pre = null;
            }
            return true;
        } catch (Exception e) {
            this.print("Error occured");
        }
        return false;
    }

    public boolean deleteLast() {

        try {
            if (this.head == null) {
                this.print("Nothing to delete");
            } else {
                // Node temp = this.head;
                // while (temp.next.next != null) {
                // temp = temp.next;
                // }
                // this.print("Going to delete : " + temp.next.data);
                // temp.next = null;
                this.end.pre.next = null;
                this.end = this.end.pre;
            }
        } catch (Exception e) {
            this.print("Error occured");
        }
        return false;
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

                            // searching node for particular position.
                            Node found = this.find(position);

                            this.print("Going to delete : " + found.next.data);
                            found.next = found.next.next;
                            found.next.pre = null;
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

    /**
     * This function should be more flexible to search in a list in both directions.
     * Currently it is searching in one direction.
     * 
     * @param position
     * @return
     */
    public Node find(int position) {
        // this.print("Finding for " + position);
        position = position - 1;
        // taking first node reference for traversing
        Node temp = this.head;
        int count = 1;
        // traversing to the last element
        while (temp.next.next != null) {
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
        DoublyLinkedList llist = new DoublyLinkedList();

        // llist.addLast(100);
        // llist.addLast(200);
        llist.addFirst(50);
        llist.addFirst(40);
        // llist.addLast(20);
        // llist.addLast(10);
        // llist.addLast(05);
        llist.add(2, 1000);
        llist.add(2, 2000);
        // llist.deleteFirst();
        // llist.deleteLast();
        llist.update(2, 41);
        llist.update(3, 42);
        llist.delete(200);
        llist.show(true);

        // llist.show(true);
        // llist.add(2, 3000);
        // llist.print(Integer.toString(llist.end.data));
        // llist.print(Integer.toString(llist.head.data));
        // llist.addFirst(500);
        // llist.add(1, 40);
        // llist.update(3, 39);
        // llist.update(4, 201);
        // llist.update(2, 101);
        // llist.sort();
        // llist.show(false);
        // llist.show();
        // llist.show();
    }
}