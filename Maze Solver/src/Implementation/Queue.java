package Implementation;

import java.util.EmptyStackException;



public class Queue implements Implementation {
	MyLinkedList Lista =  new LinkedList();
	@Override
	public void push(Object item) {
		// TODO Auto-generated method stub
		Lista.add(item);
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(Lista.size()==0)throw new EmptyStackException();
		Object o = Lista.get(0);
		Lista.remove(0);
		return o;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return Lista.isEmpty();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return Lista.size();
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	

}
