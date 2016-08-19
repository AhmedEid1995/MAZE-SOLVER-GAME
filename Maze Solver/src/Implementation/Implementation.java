package Implementation;

public interface Implementation {
	/**
	 * Inserts a specified element at the specified position in the list.
	*/
		public void add(int index, Object element);
	/**
	 * Removes the element at the top of stack and returns that element.
	*/
		public  Object pop();
	
	/**
	 * Pushes an item onto the top of this stack.
	*/
		public void push(Object element);
	/** Tests if this stack is empty */
		public boolean isEmpty();
	/** Returns the number of elements in the stack. */
		public int size();
}