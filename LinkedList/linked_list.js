class LinkList {
  constructor() {
    this.Node = class {
      constructor() {
        this.data = 0;
        this.next = null;
      }
    };
    this.head = null;
  }

  // add node at first place
  addFirst = (data) => {
    let node = new this.Node();
    node.data = data;
    node.next = this.head;
    this.head = node;
  };

  // show the list
  show = () => {
    let temp = this.head;
    let l = "";
    while (temp !== null) {
      l = l + temp.data + " -> ";
      temp = temp.next;
    }
    l = l + "null";

    console.log("list");
    console.log(l);
  };

  // add node at first place
  addLast = (data) => {
    let node = new this.Node();
    node.data = data;
    node.next = null;
    if (this.head) {
      let temp = this.head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = node;
    } else {
      this.head = node;
    }
  };
}

const list = new LinkList();
list.addLast(100);
list.addLast(200);
list.addFirst(50);
list.show();