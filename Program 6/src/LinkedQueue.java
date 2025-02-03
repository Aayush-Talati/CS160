import java.util.LinkedList;
import java.util.Iterator;
public class LinkedQueue<T> implements QueueInterface<T>, Iterable<T>{

    private LinkedList<Object> queue;
    public LinkedQueue() {
        queue = new LinkedList<>();
    }
    @Override
    public void enqueue(T newEntry) {
        queue.addLast(newEntry);
    }
    @Override
    public T dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot dequeue from an empty queue");
        }
        return (T) queue.removeFirst();
    }
    @Override
    public T getFront() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException("Cannot get front of an empty queue");
        }
        return (T) queue.getFirst();
    }
    @Override
    public boolean isEmpty() {
        if (queue.isEmpty() == false) {
            return false;
        }
        return true;
    }
    @Override
    public void clear() {
        queue.clear();
    }

    public Object[] toArray() {
        return queue.toArray();
    }

    public Iterator<T> iterator() {
        return (Iterator<T>) queue.iterator();
    }

}
