package queues;
import exceptionclasses.EmptyQueueException;

/**
 * <p>Title: The LinkedQueue Class</p>
 *
 * <p>Description: Defines the properties and behaviors of a linked queue.</p>
 *
 * @author Hamin Choi
 */
public class LinkedQueue<E> implements QueueADT<E>
{
    protected Node<E> front, rear; //references to the first and last nodes

    /**
     * default constructor - creates an empty queue
     */
    public LinkedQueue()
    {
        front = rear = null;
    }

    /**
     * enqueue method - adds the specified item to the rear of the queue
     * @param newItem a reference to the item to be added to the queue
     */
    public void enqueue (E newItem)
    {
        if (front == null) {
            front = new Node<E>(newItem);
            rear = front;
        }
        else {
            rear.setNext(new Node<E>(newItem));
            rear = rear.getNext();
        }
    }

    /**
     * dequeue method - removes the item at the front of the queue
     * @return a reference to the item removed from the front of the queue
     * @throws an EmptyQueueException if the queue is empty
     */
    public E dequeue() throws EmptyQueueException
    {
        if (front == null) {
            throw new EmptyQueueException("LinkedQueue collection is empty");
        }
        E returnMe = front.getItem();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        return returnMe;
    }

    /**
     * front method - returns a reference to the item at the front of the queue
     * without removing it from the queue
     * @return a reference to the item at the front of the queue
     * @throws an EmptyQueueException if the queue is empty
     */
    public E front()
    {
        return front.getItem();
    }

    /**
     * isEmpty method - determines whether or not the queue is empty
     * @return true if the queue is empty; false if the queue is not empty
     */
    public boolean isEmpty()
    {
        if (size() == 0) {
            return true;
        }
        else return false;
    }

    /**
     * size method - returns a count of the number of items in the queue
     * @return the number of items in the queue
     */
    public int size()
    {
        Node<E> temp = front;
        int count = 0;
        while (temp != null) {
            if (temp.getItem() != null) {
                count++;
                temp = temp.getNext();
            }
        }
        return count;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new EmptyQueueException("LinkedQueue is empty");
        }
        E returnMe = rear.getItem();
        Node<E> current = front;
        if (current.getNext() != null) {
            while (current.getNext() != rear) {
                current = current.getNext();
            }
        }
        else if (current.getNext() == null) {
            front = null;
            rear = null;
        }
        current.setNext(null);  //  deleting the node at the last
        rear = current;
        return returnMe;
    }

    /**
     * search method - returns the 1-based position where an item is on the stack.
     * If the item is on the stack, the method returns the distance from the top
     * of the stack; the topmost item on the stack is considered to be at distance
     * 1. The equals method is used to compare target to the items on the stack.
     * @param target a reference to the item to search for
     * @return the 1-based position from the top of the stack where the item
     * is located; returns -1 if the item is not on the stack
     */
    public int search(E target)
    {
        Node<E> temp = front;
        int count = 0;
        int returnMe = -1;
        while (temp != null) {
            count++;
            if (temp.getItem().equals(target)) {
                returnMe = count;
            }
            temp = temp.getNext();
        }
        return returnMe;
    }

    /**
     * toString method - returns a String representing the state of the queue
     * @return a string containing all items in the queue
     */
    public String toString()
    {
        Node<E> temp = front;
        String returnMe = "";
        while (temp != null) {
            returnMe += temp.getItem().toString() + "\n";
            temp = temp.getNext();
        }
        return returnMe;
    }
}
