package Part1.Week2;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node first;
    private int length = 0;

    // construct an empty deque
    public Deque() {
        first = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return first == null;
    };

    // return the number of items on the deque
    public int size() {
        return length;
    };

    // add the item to the front
    public void addFirst(Item item) {
        illegalItem(item);
        Node currentFirst = first;
            first = new Node();
            first.next = currentFirst;
            first.item = item;
    };

    // add the item to the back
    public void addLast(Item item) {
        illegalItem(item);
        Node nextNode = first;
        if (nextNode == null)
            addFirst(item);
        else {
            while (nextNode.next != null) {
                nextNode = nextNode.next;
            }
            nextNode.next = new Node();
            nextNode.next.item = item;
            nextNode.next.next = null;
        }    
    };

    // remove and return the item from the front
    public Item removeFirst() {

    };

    // remove and return the item from the back
    public Item removeLast() {};

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {};

    private void illegalItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Please provide an item that is of type Item");
    }

    // unit testing (required)
    public static void main(String[] args) {};

}
