
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    // global variables for the Deque.
    DoubleNode start;
    DoubleNode end;
    int size;

    /**
     * With this constructor I create the start and end of the Deque and inialize
     * the current size to 0.
     * 
     */
    public Deque() {
        this.start = null;
        this.end = null;
        this.size = 0;

    }

    /**
     * This inner-class is used to create the Node objects that are used to store
     * Items in the Deque; it has a last and next variable that is used to traverse
     * over the linked list as well as a conent variable used to reference the new
     * item added to the Deque.
     * 
     */
    private class DoubleNode {
        public DoubleNode last;
        public DoubleNode next;
        public Item content;

    }

    /**
     * This method is used to dynamically check if the current instance of the Deque
     * is empty; (size == 0).
     * 
     * @return boolen; true if size is < 1 OR false otherwise.
     */
    public boolean isEmpty() {

        return this.size() == 0;
    }

    /**
     * This method is used to dynmaically check the current size of the Deque.
     * 
     * @return an int equal to the number of current DoubleNode objects in the
     *         Deque.
     */
    public int size() {

        return this.size;
    }

    /**
     * This method creates a new DoubleNode iteam and inserts it to the front of the
     * Deque, then the size of the current Deque is increased.
     * 
     * @param item the new data that is to be added to the Deque.
     */
    public void addFirst(Item item) {
        DoubleNode newNode = new DoubleNode();
        newNode.content = item;

        if (item == null) {
            throw new NullPointerException();
        } else if (isEmpty()) {
            start = newNode;
            end = newNode;
        } else {
            start.last = newNode;
            start = newNode;

        }
        size++;
    }

    /**
     * This method creates a new DoubleNode iteam and inserts it to the end of the
     * Deque, then the size of the current Deque is increased.
     * 
     * @param item the new data that is to be added to the Deque.
     */
    public void addLast(Item item) {
        DoubleNode newNode = new DoubleNode();
        newNode.content = item;

        if (item == null) {
            throw new NullPointerException();
        } else if (isEmpty()) {
            end = newNode;
            start = newNode;

        } else {
            end.next = newNode;
            end = newNode;

        }
        size++;
    }

    /**
     * This method removes the first DoubleNode object in the Deque and returns the
     * conent that was stored in that DoubleNode as an Item, then the current size
     * is decreased.
     * 
     * @return an Item that is the conent that was stored in the first DoubleNode.
     */
    public Item removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {

            Item firstItem = start.content;
            start = start.next;
            size--;
            return firstItem;
        }
    }

    /**
     * This method removes the last DoubleNode object in the Deque and returns the
     * conent that was stored in that DoubleNode as an Item, then the current size
     * is decreased.
     * 
     * @return an Item that is the conent that was stored in the first DoubleNode.
     */
    public Item removeLast() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {

            Item lastItem = end.content;
            end = end.last;
            size--;
            return lastItem;
        }
    }

    /**
     * 
     */
    public Iterator<Item> iterator() {
        return null;

    }

    /**
     * 
     * 
     * @param args
     */
    public static void main(String[] args) {

    }
}