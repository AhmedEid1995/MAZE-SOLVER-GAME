package Implementation;



import java.util.EmptyStackException;

public class Stack implements Implementation{
	MyLinkedList Lista =new LinkedList();
	public int size=0;
//////////////////////////////////////////////////////////////////////////////
	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		Lista.add(Lista.size()-index, element);
		
	}
//////////////////////////////////////////////////////////////////////////////
	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(Lista.size()==0)throw new EmptyStackException();
		Object o=Lista.get(0);
		Lista.remove(0);
		return o;
	}

//////////////////////////////////////////////////////////////////////////////
	@Override
	public void push(Object element) {
		// TODO Auto-generated method stub
		Lista.add(0,element);
	}
//////////////////////////////////////////////////////////////////////////////
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return Lista.size()==0;
	}
//////////////////////////////////////////////////////////////////////////////
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return Lista.size();
	}

}
