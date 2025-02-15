package gray.adts.stack;

import gray.adts.stack.Stack;


import java.util.EmptyStackException;

/**
 * An fawlty implementation of the Stack ADT based on a singly-linked list.
 * This implementation does not use a dummy node for the top of the stack.
 * Thus an empty stack has top referencing null.
 *
 * Note: "Fawlty" is NOT a typo! It is a nod to the British comedy Fawlty 
 * Towers with John Cleese. 
 */
public class FawltyStack<E> implements Stack<E> {
  private int size;
  private SLNode<E> top;

  public FawltyStack() {
    size = 0;
    top = null;
  }

  public void push( E element ) {
    SLNode<E> newTop = new SLNode<E> ( element, top );
    top = newTop;
    size++;
  }

  public E peek() {
    if ( isEmpty() ) {
      throw new EmptyStackException();
    }
    return top.getElement();
  }

  public E pop() {	  
    SLNode<E> temp = top.getSuccessor();
    SLNode<E> topRetrun = top;
    top = temp;
    size--;
    return topRetrun.getElement();
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private class SLNode<E> {
    E element; // the data field
    SLNode<E> successor; // the link to next (successor) SLNode

    /**
     * Constructor. Set both fields of the node to null.
     */
    public SLNode() {
      this.element = null;
      this.successor = null;
    }

    /**
     * Constructor. Initialize the node's data fields to the values provided.
     * @param list_element - the value to be stored in this node.
     * @param successor_node - a reference to the node's new successor.
     */
    public SLNode( E list_element, SLNode<E> successor_node ) {
      this.element = list_element;
      this.successor = successor_node;
    }

    /**
     * Set the element field for this node.
     * @param list_element - the new value to be stored in this node.
     */
    public void setElement( E list_element ) {
      this.element = list_element;
    }

    /**
     * Return the element field of this node.
     */
    public E getElement() {
      return this.element;
    }

    /**
     * Return a reference to the next node in the list.
     */
    public SLNode<E> getSuccessor() {
      return this.successor;
    }

    /**
     * Set the successor to this node in the list.
     * @param successor_node - a reference to the node's new successor.
     */
    public void setSuccessor( SLNode<E> successor_node ) {
      this.successor = successor_node;
    }
  }
}
