package proj3fa15;

/**
 * <p>
 * Title: Node Class
 * </p>
 * <p>
 * Description: Defines a node class capable of storing a reference to an object
 * and a reference to the next node in a linked list. Accessor and mutators are
 * defined for both. Generic is not used to define this class so it can only store
 * card types of data. 
 * </p>
 *
 * @author Bikash Mainali
 */
public class Node
{
	private Card data; // a reference to an object of type E
	private Node next; // the address of the next node in the list

	/**
	 * default constructor - initializes data and next to null
	 */
	public Node()
	{
		data = null;
		next = null;
	}

	/**
	 * parameterized constructor - initializes data to the user specified value;
	 * next is set to null
	 * 
	 * @param newItem
	 *            the value to be stored in the node
	 */
	public Node(Card newItem)
	{
		data = newItem;
		next = null;
	}

	/**
	 * parameterized constructor - initializes data and next to user specified
	 * values
	 * 
	 * @param newItem
	 *            the object reference to be stored in the node
	 * @param nextItem
	 *            the reference to the next node in the list
	 */
	public Node(Card newItem, Node nextItem)
	{
		data = newItem;
		next = nextItem;
	}

	/**
	 * setItem - stores a new value in data
	 * 
	 * @param newItem
	 *            the object reference to be stored in the node
	 */
	public void setItem(Card newItem)
	{
		data = newItem;
	}

	/**
	 * setNext - stores a new value in next
	 * 
	 * @param nextItem
	 *            the reference to be stored in next
	 */
	public void setNext(Node nextItem)
	{
		next = nextItem;
	}

	/**
	 * getItem - returns the reference stored in data
	 * 
	 * @return a reference to the data stored in the node
	 */
	public Card getItem()
	{
		return data;
	}

	/**
	 * getNext - returns the reference stored in next
	 * 
	 * @return the reference stored in next
	 */
	public Node getNext()
	{
		return next;
	}
}
