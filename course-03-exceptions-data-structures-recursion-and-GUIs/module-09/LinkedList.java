// Represents a LinkedList comprised of Nodes. This is a generic
// class! Be sure to reflect the use of generics in the class
// declaration.

// Interface:
// This class should implement the provided List<T> interface
// Variables
// Do not create any other instance variables than specified below.
// Any extra instance variables will result in deductions. All
// variables must follow the rules of encapsulation.
//
// A variable named head
//
// Variable of type Node (with generic type attached)
// This variable represents the head of the LinkedList
// If the list is empty, set this to null
// You must name this variable head
//
// A variable named tail
// Variable of type Node (with generic type attached)
// This variable represents the tail of the LinkedList
// If the list is empty, set this to null
// You must name this variable tail
//
// A variable named size
// Variable of type integer
// This variable represents the current size of the LinkedList
// If the list is empty, set this to 0
// You must name this variable size

// Constructors
// A no-args constructor setting head and tail to null

// Methods
// Helper methods are discouraged because a proper LinkedList should
// not require them. Any extra methods will result in a 5 point
// deduction for code style. All methods must have the proper
// visibility to be used where it is specified that they are used.
//
// A getter for the head instance variable named getHead
//
// A getter for the tail instance variable named getTail
//
// You must override all necessary methods to correctly implement
// List<T> interface

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }

    public void addAtIndex(T data, int index) {

        if (index < 0 || index > this.size) {
            String errorMessage = "Your index is out of the list bounds";
            throw new IllegalArgumentException(errorMessage);
        } else if (data == null) {
            String errorMessage = "You cannot add null data to the list";
            throw new IllegalArgumentException(errorMessage);
        } else {
            // We create a new node that we will insert.
            Node<T> newNode = new Node(data, null);
            if (index == 0) {
                newNode.setNext(this.head);
                this.head = newNode;
            } else {
                // We move along the list until we reach the Node prior to
                // the insertion location.
                int currentPosition = 0;
                Node<T> currentNode = this.head;
                while (currentPosition < (index - 1)) {
                    currentNode = currentNode.getNext();
                    currentPosition++;
                }

                // This node is currently at the insertion location.
                Node<T> oldNext = currentNode.getNext();

                // We update the pointers of the node before the
                // insertion location as well as the new node.
                currentNode.setNext(newNode);
                newNode.setNext(oldNext);
            }

            if (index == this.size) {
                this.tail = newNode;
            }

            this.size++;
        }
    }

    public T getAtIndex(int index) {
        if (index < 0 || index > (this.size - 1)) {
            String errorMessage = "Your index is out of the list bounds";
            throw new IllegalArgumentException(errorMessage);
        } else {
            T returnData;
            if (index == 0) {
                returnData = this.head.getData();
            } else if (index == (this.size - 1)) {
                returnData = this.tail.getData();
            } else {
                // We move along the list until we reach the Node at
                // the specified index.
                int currentPosition = 0;
                Node<T> currentNode = this.head;
                while (currentPosition < index) {
                    currentNode = currentNode.getNext();
                    currentPosition++;
                }

                returnData = currentNode.getData();
            }

            return returnData;
        }
    }

    public T removeAtIndex(int index) {
        if (index < 0 || index > (this.size - 1)) {
            String errorMessage = "Your index is out of bounds";
            throw new IllegalArgumentException(errorMessage);
        } else {
            Node<T> nodeToRemove;
            Node<T> previousNode = null;
            if (index == 0) {
                previousNode = null;
                nodeToRemove = this.head;
                this.head = nodeToRemove.getNext();
            } else {
                // We move along the list until we reach the Node at
                // the specified index.
                int currentPosition = 0;
                Node<T> currentNode = this.head;
                while (currentPosition < index) {
                    previousNode = currentNode;
                    currentNode = previousNode.getNext();
                    currentPosition++;
                }
                nodeToRemove = currentNode;
                previousNode.setNext(nodeToRemove.getNext());
                nodeToRemove.setNext(null);
            }

            if (index == (this.size - 1)) {
                this.tail = previousNode;
            }

            this.size--;
            return nodeToRemove.getData();
        }
    }

    public T remove(T data) {
        if (data == null) {
            String errorMessage = "You cannot remove null data from the list";
            throw new IllegalArgumentException(errorMessage);
        }

        // We move along the list until we reach a Node with the
        // specified data or reach the end of the list.
        int currentPosition = 0;
        T returnData = null;
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getData().equals(data)) {
                returnData = currentNode.getData();
                break;
            }

            currentNode = currentNode.getNext();
            currentPosition++;
        }

        // In this case, we have not found the specified data in the
        // list.
        if (returnData == null) {
            String errorMessage = "The data is not present in the list.";
            throw new NoSuchElementException(errorMessage);
        }

        return this.removeAtIndex(currentPosition);
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return (this.size <= 0);
    }

    public int size() {
        return this.size;
    }

}
