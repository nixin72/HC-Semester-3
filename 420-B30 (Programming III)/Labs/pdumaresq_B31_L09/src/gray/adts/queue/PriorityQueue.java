package gray.adts.queue;

public interface PriorityQueue<E> {
	public void enqueue(int p, E e);
	
	public void enqueue(E e);
	
	public E dequeue();
	
	public E peek();
	
	public int size();
	
	public boolean isEmpty();
	
	public void clear();
}
