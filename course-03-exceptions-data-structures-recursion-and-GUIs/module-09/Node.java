// Represents the nodes which will make up the LinkedList. This is a
// generic class! Be sure to reflect the use of generics in the class
// declaration.

// Variables
// Do not create any other instance variables than specified below.
// Any extra instance variables will result in deductions. All
// variables must follow the rules of encapsulation.
//
// A variable named data
// Variable of the generic type holding the data stored in the node.
//
// A variable named next
// Variable of the type Node (with generic type attached on) that acts
// as a “next” pointer, representing the Node that is next in the
// LinkedList

// Constructors
// A constructor that takes in two arguments exactly in the given
// order: data and the next node and assigns it to instance variables
// accordingly.
//
// A constructor that takes in one argument: data
// The next pointer is set to null
// Should use constructor chaining

// Methods
// Do not create any other methods than those specified. Any extra
// methods will result in point deductions. All methods must have the
// proper visibility to be used where it is specified they are used.
//
// Getters and setters for the instance variables

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data) {
        this(data, null);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
