
import java.util.Random;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomLinkedQueue<Item> implements Iterable<Item> {

    private Node start;
    private Node end;
    private Random rand;
    private int size;

    public RandomLinkedQueue() {

        this.size = 0;
        this.rand = new Random();
    }

    private class Node {

        private Node next;
        private Item content;
    }

    private int newIndex() {

        return rand.nextInt(size());
    }

    public boolean isEmpty() {

        return this.size == 0;
    }

    public int size() {

        return this.size;
    }

    public void enqueue(Item newContent) {
        Node newNode = new Node();
        newNode.content = newContent;

        if (isEmpty()) {

            start = newNode;
            end = newNode;
        } else {

            end.next = newNode;
            end = newNode;
        }
        size++;
    }

    public Item dequeue() {

        Item item;
        Node lastNode = this.start;
        int index = newIndex();
        if (index == 0) {

            item = this.start.content;
            this.start = this.start.next;
            size--;
            return item;
        }

        for (int i = 1; i < size; i++) {

            if (index == i) {

                item = lastNode.next.content;
                lastNode.next = lastNode.next.next;
                size--;
                return item;
            }

            lastNode = lastNode.next;
        }

        throw new NoSuchElementException();
    }

    public Item sample() {

        int index = newIndex();
        if (index == 0) {

            return this.start.content;
        } else if (index == size()) {

            return this.end.content;
        }

        Node current = this.start.next;
        for (int i = 1; i < size; i++) {

            if (index == i) {
                return current.content;
            }
            current = current.next;
        }
        throw new NoSuchElementException();
    }

    @Override
    public Iterator<Item> iterator() {

        return new Iterator<Item>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                if (start != null) {

                    return start.next != null;

                }
                return false;
            }

            @Override
            public Item next() {

                if (index == 0) {

                    index++;
                    return start.content;
                } else if (start != null) {

                    start = start.next;
                    return start.content;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static void main(String[] args) {

        RandomLinkedQueue<Object> Queue = new RandomLinkedQueue<Object>();

        Queue.enqueue(280);
        Queue.enqueue("Random Queue Testing");
        Queue.enqueue(7.2);
        Queue.enqueue("Finnegan");
        Queue.enqueue("JAYNE");

        System.out.println("\nThis is the dequeue that will be removed from the list: " + Queue.dequeue() + "\n");
        System.out.println("This is the sample that will stay in the list: " + Queue.sample() + "\n");

        for (Object i : Queue) {

            System.out.println(i);
        }

    }

}