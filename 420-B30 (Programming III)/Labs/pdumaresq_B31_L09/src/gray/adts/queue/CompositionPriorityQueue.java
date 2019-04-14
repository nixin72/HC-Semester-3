package gray.adts.queue;

@SuppressWarnings("serial")
public class CompositionPriorityQueue<E> implements PriorityQueue<E> {

	Queue<E> queue = new ListQueue<E>();
	
	@Override
	public void enqueue(E e) {
		queue.enqueue(e);	
	}
	
	@Override
	public void enqueue(int p, E e) {
		p--;
		Queue<E> temp = new ListQueue<E>();
		
		int q = 0;
		while (q < queue.size()+q) {
			if (q == p) {
				temp.enqueue(e);
			}
			else {
				temp.enqueue(queue.dequeue());
			}
			q++;
		}
		queue = temp;
	}

	@Override
	public E dequeue() {
		return queue.dequeue();
	}

	@Override
	public E peek() {
		return queue.peek();
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public void clear() {
		queue.clear();
	}
}
