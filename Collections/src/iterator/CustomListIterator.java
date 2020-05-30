package iterator;
import java.util.Iterator; 

// Custom Linked List class using Generics 
class CustomList<T> implements Iterable<T> { 
	CustomNode<T> head, tail; 

	// add new Element at tail of the linked list in O(1) 
	public void add(T data) 
	{ 
		CustomNode<T> node = new CustomNode<>(data, null); 
		if (head == null) 
			tail = head = node; 
		else { 
			tail.setNext(node); 
			tail = node; 
		} 
	} 

	// return Head 
	public CustomNode<T> getHead() 
	{ 
		return head; 
	} 

	// return Tail 
	public CustomNode<T> getTail() 
	{ 
		return tail; 
	} 

	// return Iterator instance 
	@Override
	public Iterator<T> iterator() 
	{ 
		return new ListIterator<T>(this); 
	} 
} 

class ListIterator<T> implements Iterator<T> { 
	CustomNode<T> current; 

	// initialize pointer to head of the list for iteration 
	public ListIterator(CustomList<T> list)
	{ 
		current = list.getHead(); 
	} 

	// returns false if next element does not exist
	@Override
	public boolean hasNext() 
	{ 
		return current != null; 
	} 

	// return current data and update pointer
	@Override
	public T next() 
	{ 
		T data = current.getData(); 
		current = current.getNext(); 
		return data; 
	} 

	// implement if needed
	@Override
	public void remove() 
	{ 
		throw new UnsupportedOperationException(); 
	} 
} 

// Constituent Node of Linked List 
class CustomNode<T> { 
	T data; 
	CustomNode<T> next; 
	public CustomNode(T data, CustomNode<T> next) 
	{ 
		this.data = data; 
		this.next = next; 
	} 

	// Setter getter methods for Data and Next Pointer 
	public void setData(T data) 
	{ 
		this.data = data; 
	} 

	public void setNext(CustomNode<T> next) 
	{ 
		this.next = next; 
	} 

	public T getData() 
	{ 
		return data; 
	} 

	public CustomNode<T> getNext() 
	{ 
		return next; 
	} 
} 

// Driver class 
public class CustomListIterator { 
	public static void main(String[] args) 
	{ 
		// Create Linked List 
		CustomList<String> myList = new CustomList<>(); 

		// Add Elements 
		myList.add("abc"); 
		myList.add("mno"); 
		myList.add("pqr"); 
		myList.add("xyz"); 

		// Iterate through the list using For Each Loop 
		for (String string : myList) 
			System.out.println(string); 
	} 
} 
