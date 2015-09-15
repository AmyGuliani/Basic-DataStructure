class StackLinked
{
	class Node
	{
		int key;
		int value;
		Node next;
	}
	Node start=null;
	int push(int key,int value)
	{
		Node n = new Node();
		n.key = key;
		n.value = value;
		n.next = start;
		start = n;
		return 1;
	}
	void print()
	{
		Node n = start;
		while(n!=null)
		{
			System.out.println("key = "+n.key+" value = "+n.value);
			n = n.next;
		}
	}
}
