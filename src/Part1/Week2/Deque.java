package Part1.Week2;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        private Item item;
        private Node next = null;
        private Node previous = null;

        public Node(Item item) {
            this.item = item;
        }

        public Item getItem() {
            return item;
        }
  
        public Node getNext() {
            return next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node first, last;
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
        Node node = new Node(item);

        if (first == null)
            first = last = node;
        else {
            node.setNext(this.first);
            this.first.setPrevious(node);
            this.first = node;
        }
        this.length++;
    };

    // add the item to the back
    public void addLast(Item item) {
        illegalItem(item);
        Node node = new Node(item);

        if (first == null)
            first = last = node;
        else {
           this.last.setNext(node);
           node.setPrevious(this.last);
           this.last = node;
        }
       this.length++; 
    };

    // remove and return the item from the front
    public Item removeFirst() {
        if (this.first == null) throw new NoSuchElementException();
        Node firstNode = first;
        this.first = firstNode.getNext();
        if (this.first.getNext() == null) this.last = null;
        this.length--;
        return firstNode.getItem();
    };

    // remove and return the item from the back
    public Item removeLast() {
        if (this.last == null) throw new NoSuchElementException();
        Node currentLast = this.last;
        this.last = this.last.getPrevious();
        this.last.setNext(null);
        this.length--;
        return currentLast.getItem();
    };

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
       return new Iterator<Item>() {
           Node current = first;

           public boolean hasNext() {
               return current.next != null;
           };

           public Item next() {
               if (hasNext()) {
                   current = current.getNext();
                   return current.getPrevious().getItem();
               };
               throw new NoSuchElementException();
           };

           public void remove() {
               throw new UnsupportedOperationException();
           };
       };
    };

    private void illegalItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Please provide an item that is of type Item");
    }

    // unit testing (required)
    public static void main(String[] args) {
        
    };

}
