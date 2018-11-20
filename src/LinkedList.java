
public class LinkedList {
    private Node head;
    private Node tail;

    /**
     * 1. Append an element into the linkedlist
     */
    public void append(int value) {
        Node node = new Node(value);

        // If the list is empty
        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }
        this.tail = node;
    }

    /**
     * 2. Remove the tail element from a linkedlist
     */
    public void removeTail() {
        if (this.tail != null) {
            // If there is only 1 node in the list
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            } else {
                Node node = this.head;
                while (node.next != this.tail) {
                    node = node.next;
                }
                this.tail = node;
                this.tail.next = null;
            }
        }
    }

    /**
     * 3. Remove all element in the linkedlist that is great than a target value
     */
    public void removeAllNodesGreaterThan(int value) {
        if (this.head != null) {
            Node previous = null;
            Node node = this.head;
            Node next = node.next;
            while (node != null) {
                if (node.value > value) {
                    this.removeNode(previous, node, next);
                } else {
                    previous = node;
                }
                node = next;
                if (next != null) {
                    next = next.next;
                }
            }
        }
    }

    /**
     * remove a node 
     * */
    private void removeNode(Node previous, Node node, Node next) {
        // If removing tail node
        if (this.tail == node) {
            this.tail = previous;
        }

        // If removing head node
        if (this.head == node) {
            this.head = node.next;
        } else {
            previous.next = next;
        }
        node.next = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.head != null) {
            Node node = this.head;
            while (node != null) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(node.value);
                node = node.next;
            }
        }
        return stringBuilder.toString();
    }

    public class Node {
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.append(i);
        }
        System.out.println("Initial:");
        System.out.println(linkedList);
        System.out.println("-----------");

        System.out.println("Removing:");
        for (int i = 0; i < 15; i++) {
            linkedList.removeTail();
            System.out.println(linkedList);
        }
        System.out.println("-----------");

        System.out.println("Reappend:");
        for (int i = 0; i < 20; i++) {
            linkedList.append(i);
        }
        System.out.println(linkedList);
        System.out.println("-----------");

        System.out.println("Removing nodes with value > 15:");
        linkedList.removeAllNodesGreaterThan(15);
        System.out.println(linkedList);
        System.out.println("-----------");

        System.out.println("Removing modes with value > -1:");
        linkedList.removeAllNodesGreaterThan(-1);
        System.out.println(linkedList);
        System.out.println("-----------");

        linkedList.append(4);
        linkedList.append(10);
        linkedList.append(5);
        linkedList.append(3);
        linkedList.append(6);
        linkedList.append(7);
        linkedList.append(9);
        linkedList.append(1);
        linkedList.append(8);
        linkedList.append(0);
        linkedList.append(2);
        System.out.println(linkedList);
        System.out.println("-----------");

        System.out.println("Removing modes with value > 5:");
        linkedList.removeAllNodesGreaterThan(5);
        System.out.println(linkedList);
        System.out.println("-----------");
    }
}