
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
        this.start = new DoubleNode();
        this.end = new DoubleNode();
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

        return this.size == 0;
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

        if (this.size() == 0) {
            start = newNode;
            end = newNode;
        } else {
            start.last = newNode;
            start = newNode;

        }
        this.size++;
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

        if (this.size() == 0) {
            end = newNode;
            start = newNode;

        } else {
            end.next = newNode;
            end = newNode;

        }
        this.size++;
    }

    /**
     * This method removes the first DoubleNode object in the Deque and returns the
     * conent that was stored in that DoubleNode as an Item, then the current size
     * is decreased.
     * 
     * @return an Item that is the conent that was stored in the first DoubleNode.
     */
    public Item removeFirst() {

        if (this.size() == 0) {
            throw new NoSuchElementException();
        } else {

            Item firstItem = start.content;
            start.next = start;
            this.size--;
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

        if (this.size() == 0) {
            throw new NoSuchElementException();
        } else {

            Item lastItem = end.content;
            end.last = end;
            this.size--;
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