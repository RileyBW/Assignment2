
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private int size;
	private Item[] randQueue;

	@SuppressWarnings("unchecked")
	public RandomizedQueue() {

		randQueue = (Item[]) new Object[6];

	}

	public boolean isEmpty() {

		return size == 0;
	}

	public int size() {

		return this.size;
	}

	public void enqueue(Item item) {

		if (item == null) {
			throw new NoSuchElementException();
		}

		if (size == randQueue.length) {

			resizeArr(randQueue.length * 2);

		}

		randQueue[size++] = item;

	}

	public Item dequeue() {

		if (isEmpty()) {

			throw new NoSuchElementException();

		}

		int rand = randomNum();
		Item item = randQueue[rand - 1];

		if (rand != size - 1) {

			randQueue[rand] = randQueue[size - 1];

		}

		randQueue[size - 1] = null;
		size--;

		if (size == randQueue.length / 4) {

			resizeArr(randQueue.length / 2);

		}

		return item;
	}

	public Item sample() {

		if (isEmpty()) {
			throw new NoSuchElementException();

		}

		int rand = randomNum();

		return randQueue[rand];

	}

	private int randomNum() {

		int rand = ThreadLocalRandom.current().nextInt(1, size);

		return rand;
	}

	@Override
	public Iterator<Item> iterator() {

		return new List<Item>();

	}

	@SuppressWarnings("hiding")
	private class List<Item> implements Iterator<Item> {

		@SuppressWarnings("unchecked")
		private Item[] randCopy = (Item[]) new Object[randQueue.length];
		private int copySize = size;

		@SuppressWarnings("unchecked")
		public List() {

			for (int i = 0; i < randQueue.length; i++) {
				randCopy[i] = (Item) randQueue[i];
			}

		}

		@Override
		public boolean hasNext() {

			return copySize > 0;

		}

		@Override
		public Item next() {

			if (!hasNext()) {

				throw new NoSuchElementException();

			}

			int rand = randomNum();
			Item item = randCopy[rand];

			if (rand != copySize - 1) {
				randCopy[rand] = randCopy[copySize - 1];
			}

			randCopy[copySize - 1] = null;
			copySize--;

			return item;

		}

		public void remove() {

			throw new UnsupportedOperationException();

		}

	}

	private void resizeArr(int capacity) {

		assert capacity >= size;
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[capacity];

		for (int i = 0; i < size; i++) {

			temp[i] = randQueue[i];

		}

		randQueue = temp;

	}

	public static void main(String[] args) {

		RandomizedQueue<Object> rq = new RandomizedQueue<Object>();

		rq.enqueue(1);
		rq.enqueue("List");
		rq.enqueue(1.10);
		rq.enqueue("apple");

		System.out.println(rq.randQueue);

		for (Object i : rq) {

			System.out.println(i);
		}

	}

}
