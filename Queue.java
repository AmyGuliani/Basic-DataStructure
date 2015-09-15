class Queue
{
	class Node
	{
		int key;
		Node next;
	}
	private Node start,last;
	
	Queue(){
		start = null;
		last = null;
	}
	void add(key)
	{
		Node n = new Node(key);
		if(last==null)
		{
			last = n;
			start = last;
		}
		else
		{
			last.next = n;
			last = last.next;
		}
	}
	void add(StackLinked.Node n)
	{
		
	}
	void add(Tree.Node n)
	{
		
	}
	int remove()
	{
		if(start==null)
		{
			last = null;
			return null;
		}
		else
		{
			Node ptr = start;
			start = start.next;
			return ptr.key;
		}
	}
}