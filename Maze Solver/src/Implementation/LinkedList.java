package Implementation;



public class LinkedList implements  MyLinkedList{
	public Node head=null;
	public Node tail=null;
	public int size=0;
	@Override
//////////////////////////////////////////////////////////////////////////////
	public void displayList() {
		// TODO Auto-generated method stub
		Node i = head;
		while(i!=null){
			System.out.println(i.value+" ");
			i=i.next;
		}
		
	}
//////////////////////////////////////////////////////////////////////////////
	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		if(index<0||index>size) throw new IndexOutOfBoundsException("out of boundries exeption");
		else{
			Node newNode = new Node(element);
			if(index==0){
				if(head==null){tail=newNode;head=newNode;size++;}
				else{
				newNode.next=head;
				head.prev=newNode;
				head =newNode;			
				size++;
				}
			}
			else if(index==size)add(element);
			else{
				Node attemp=head;
				for(int i=0;i<index-1;i++){
					attemp= attemp.next;
				}
				newNode.next=attemp.next;
				newNode.prev=attemp;
				attemp.next=newNode;
				Node attemp1=attemp.next;
				attemp1.prev=newNode;
				size++;
				
		}
		}
		
		
	}
//////////////////////////////////////////////////////////////////////////////
	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		Node newNode = new Node(element);
		
		if(tail==null) {head=newNode;tail=newNode;size++;}
		else{
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
			size++;
		}
		
	}
//////////////////////////////////////////////////////////////////////////////
	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if(index>=size||index<0){return null;
		}else{
			Node attemp=head;
			for(int i=0;i<index;i++ ){
				attemp=attemp.next;
			}
		
		
			return attemp.value;
		}
	}
//////////////////////////////////////////////////////////////////////////////
	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		if(index>=size||index<0){throw new IndexOutOfBoundsException("out of boundries exeption");
		}else{
			Node attemp=head;
			for(int i=0;i<index;i++ ){
				attemp=attemp.next;
			}
		
		
			attemp.value=element;
		}
		
	}
//////////////////////////////////////////////////////////////////////////////
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head=null;
		tail=null;
		size=0;
		
	}
//////////////////////////////////////////////////////////////////////////////
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size==0);
	}
//////////////////////////////////////////////////////////////////////////////
	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		if(index<0||index>=size)throw new IndexOutOfBoundsException("out of boundries exeption");
		else{
			Node attemp,attemp1;
			attemp=head;
			if(index==0&&size==1){
				head=null;
				tail=null;
				size--;
			}
			else if(index==0){
				head=head.next;
				head.prev=null;
				size--;
			}
			else if(index==size-1){tail=tail.prev;tail=null;size--;}
			else{
				for(int i=0;i<index-1;i++){
					attemp=attemp.next;
				}
				attemp1=attemp.next;
				attemp.next=attemp1.next;
				attemp1=attemp1.next;
				attemp1.prev=attemp;
				size--;

			}
		}
		
	}
//////////////////////////////////////////////////////////////////////////////
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
//////////////////////////////////////////////////////////////////////////////
	@Override
	public MyLinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		if(head==null||fromIndex<0||fromIndex>=size||toIndex>=size||toIndex<0){throw new IndexOutOfBoundsException("out of boundries exeption");}
		MyLinkedList lista=new LinkedList();
		Node attemp =head;
		
		for(int i=0;i<fromIndex;i++){
			attemp=attemp.next;
		}
		
		for(int i=fromIndex ; i<=toIndex ; i++){
			lista.add(attemp.value);
			attemp=attemp.next;
		}
		return lista;
	
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		Node attemp=head;
		for(int i=0;i<size;i++){
			if(attemp.value.equals(o))return true;
			attemp=attemp.next;
		}
		return false;
	}

}

