class LinkList {
  constructor() {
    this.Node = class Node {
      constructor() {
        this.data = 0;
        this.next = null;
      }
    };
    this.head = null;
  }

  add = (position, data) => {
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
    console.log(node);
  };

  show = () => {
    let temp = this.head;
    // console.log(temp);
    let l = "";
    while (temp !== null) {
      l = l + temp.data + " -> ";
      temp = temp.next;
    }
    l = l + "null";

    console.log("list");
    console.log(l);
  };
}

const list = new LinkList();
list.add(1, 100);
list.add(1, 200);
list.show();
