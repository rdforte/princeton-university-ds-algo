package Part1.Week2;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;

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
        first = last = null;
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
        noElementsError();     
        Node firstNode = first;

        if (this.first.getNext() == null) {
            first = last = null;
        } else {
        this.first = firstNode.getNext();
        if (this.first.getNext() == null) this.last = this.first;
        }
        this.length--;
        return firstNode.getItem();
    };

    // remove and return the item from the back
    public Item removeLast() {
        if (this.last == null) noElementsError();
        Node currentLast = this.last;
        if (this.last.previous == null) {
            first = last = null;
        } else {
            this.last = this.last.getPrevious();
            this.last.setNext(null);
        }
        this.length--;
        return currentLast.getItem();
    };

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
       return new Iterator<Item>() {
           Node current = first;

           public boolean hasNext() {
               return current != null;
           };

           public Item next() {
               if (hasNext()) {
                   Node currentNode = current;
                   current = current.getNext();
                   return currentNode.getItem();
               };
               throw new NoSuchElementException("No items to iterate");
           };

           public void remove() {
               throw new UnsupportedOperationException();
           };
       };
    };

    private void illegalItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Please provide an item that is of type Item");
    }

    private void noElementsError() {
        if (this.last == null || this.first == null)
            throw new NoSuchElementException("There are no items to remove");
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();

        for (int d : deque) {
            StdOut.println(d);
        }

    };

}
