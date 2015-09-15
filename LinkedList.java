class LinkedList
{
	class Node
	{
		int value;
		Node next;
	}
	Node start=null;
	int length()
	{
		return len(start);
	}
	int len(Node ptr)
	{
		if(ptr==null)
			return 0;
		return 1+ len(ptr.next);
	}
	void add(int value)
	{
		Node n = new Node();
		n.next = start;
		start = n;
	}
	void delete(int i)
	{
		
	}
	void Rev()
	{
		start = Reverse(start);
	}
	Node Reverse(Node ptr)
	{
		if(ptr.next==null)
			return ptr;
		Node x = Reverse(ptr.next);
		x.next = ptr.next;
		ptr.next = x;
		return ptr;
	}
	void print()
	{
		P(start);
	}
	void P(Node ptr)
	{
		if(ptr==null)
			return;
		P(ptr.next);
		System.out.print(ptr.value+" ");
	}
}